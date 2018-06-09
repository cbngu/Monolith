package gg.warcraft.monolith.spigot.world;

import gg.warcraft.monolith.api.world.block.BlockType;
import org.bukkit.Material;

public class SpigotBlockTypeMapper {

    public MaterialData map(BlockType type) {
        var material = Material.getMaterial(type.getId());
        return new MaterialData(material, type.getData());
    }

    public BlockType map(Material material) {
        return BlockType.get(material.getId(), 0);
    }

    public BlockType map(Material material, byte data) {
        return BlockType.get(material.getId(), data);
    }
}
