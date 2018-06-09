package gg.warcraft.monolith.spigot.world;

import gg.warcraft.monolith.api.world.ItemType;
import org.bukkit.Material;

public class SpigotItemTypeMapper {

    public MaterialData map(ItemType type) {
        var material = Material.getMaterial(type.getId());
        return new MaterialData(material, type.getData());
    }

    public ItemType map(Material material) {
        return ItemType.get(material.getId(), 0);
    }

    public ItemType map(Material material, byte data) {
        return ItemType.get(material.getId(), data);
    }
}
