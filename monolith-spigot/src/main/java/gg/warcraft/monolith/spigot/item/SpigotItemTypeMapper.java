package gg.warcraft.monolith.spigot.item;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.item.ItemType;
import gg.warcraft.monolith.api.item.ItemTypeUtils;
import gg.warcraft.monolith.spigot.world.MaterialData;
import org.bukkit.Material;

public class SpigotItemTypeMapper {
    private final ItemTypeUtils itemTypeUtils;

    @Inject
    public SpigotItemTypeMapper(ItemTypeUtils itemTypeUtils) {
        this.itemTypeUtils = itemTypeUtils;
    }

    public MaterialData map(ItemType type) {
        Material material = Material.getMaterial(type.getId());
        return new MaterialData(material, type.getData());
    }

    public ItemType map(Material material) {
        return itemTypeUtils.getType(material.getId(), 0);
    }

    public ItemType map(Material material, byte data) {
        return itemTypeUtils.getType(material.getId(), data);
    }
}
