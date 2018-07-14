package gg.warcraft.monolith.spigot.item;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.item.Item;
import gg.warcraft.monolith.api.item.ItemType;
import gg.warcraft.monolith.app.item.SimpleItem;
import gg.warcraft.monolith.spigot.world.MaterialData;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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
        ItemType type = itemTypeMapper.map(item.getType(), item.getData().getData());
        ItemMeta meta = item.getItemMeta();
        return new SimpleItem(type, meta.getDisplayName(), item.getAmount(), item.getDurability(), meta.getLore());
    }
}
