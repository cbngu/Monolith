package gg.warcraft.monolith.spigot.item;

import gg.warcraft.monolith.api.item.ItemType;
import gg.warcraft.monolith.spigot.world.MaterialData;
import org.bukkit.Material;

public class SpigotItemTypeMapper {

    public MaterialData map(ItemType type) {
        Material material = Material.getMaterial(type.getId());
        return new MaterialData(material, type.getData());
    }

    public ItemType map(Material material) {
        return ItemType.get(material.getId(), 0);
    }

    public ItemType map(Material material, byte data) {
        return ItemType.get(material.getId(), data);
    }
}
