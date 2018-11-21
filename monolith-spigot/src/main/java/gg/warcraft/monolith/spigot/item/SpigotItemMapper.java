package gg.warcraft.monolith.spigot.item;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.item.Item;
import gg.warcraft.monolith.api.item.ItemType;
import gg.warcraft.monolith.api.item.Skull;
import gg.warcraft.monolith.app.item.SimpleItem;
import gg.warcraft.monolith.spigot.world.MaterialData;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

public class SpigotItemMapper {
    private final SpigotItemTypeMapper itemTypeMapper;

    @Inject
    public SpigotItemMapper(SpigotItemTypeMapper itemTypeMapper) {
        this.itemTypeMapper = itemTypeMapper;
    }

    public ItemStack mapSkull(Skull skull) {
        if (skull == null) {
            return null;
        }

        ItemStack itemStack = new ItemStack(Material.SKULL_ITEM, skull.getStackSize(), (short) skull.getDamage(),
                (byte) SkullType.PLAYER.ordinal());
        SkullMeta itemMeta = (SkullMeta) itemStack.getItemMeta();
        if (skull.getName() != null) {
            itemMeta.setDisplayName(skull.getName());
        }
        itemMeta.setLore(skull.getLore());
        itemMeta.setOwner(skull.getPlayerName());
        itemMeta.addItemFlags(ItemFlag.values());
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public ItemStack map(Item item) {
        if (item == null) {
            return null;
        }

        if (item instanceof Skull) {
            return mapSkull((Skull) item);
        }

        MaterialData materialData = itemTypeMapper.map(item.getType());
        ItemStack itemStack = new ItemStack(materialData.getMaterial(), item.getStackSize(), (short) item.getDamage(),
                materialData.getData());
        ItemMeta itemMeta = itemStack.getItemMeta();
        if (item.getName() != null) {
            itemMeta.setDisplayName(item.getName());
        }
        itemMeta.setLore(item.getLore());
        itemMeta.addItemFlags(ItemFlag.values());
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
