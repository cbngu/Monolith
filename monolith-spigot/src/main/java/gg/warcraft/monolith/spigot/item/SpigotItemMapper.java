package gg.warcraft.monolith.spigot.item;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.item.Item;
import gg.warcraft.monolith.api.item.ItemType;
import gg.warcraft.monolith.app.item.SimpleItem;
import gg.warcraft.monolith.spigot.world.MaterialData;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class SpigotItemMapper {
    private final SpigotItemTypeMapper itemTypeMapper;

    @Inject
    public SpigotItemMapper(SpigotItemTypeMapper itemTypeMapper) {
        this.itemTypeMapper = itemTypeMapper;
    }

    public ItemStack map(Item item) {
        MaterialData materialData = itemTypeMapper.map(item.getType());
        ItemStack itemStack = new ItemStack(materialData.getMaterial(), item.getStackSize(), (short) item.getDamage(),
                materialData.getData());
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(item.getName());
        itemMeta.setLore(item.getLore());
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public Item map(ItemStack item) {
        if (item == null) {
            return null;
        }

        byte data = item.getData() != null ? item.getData().getData() : 0;
        ItemType type = itemTypeMapper.map(item.getType(), data);
        if (item.hasItemMeta()) {
            ItemMeta meta = item.getItemMeta();
            List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();
            return new SimpleItem(type, meta.getDisplayName(), item.getAmount(), item.getDurability(), lore);
        }
        return new SimpleItem(type, null, item.getAmount(), item.getDurability(), new ArrayList<>());
    }
}
