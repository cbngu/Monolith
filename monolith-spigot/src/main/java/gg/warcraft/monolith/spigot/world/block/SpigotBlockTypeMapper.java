package gg.warcraft.monolith.spigot.world.block;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.world.block.BlockType;
import gg.warcraft.monolith.api.world.block.BlockTypeUtils;
import gg.warcraft.monolith.spigot.world.MaterialData;
import org.bukkit.Material;

public class SpigotBlockTypeMapper {
    private final BlockTypeUtils blockTypeUtils;

    @Inject
    public SpigotBlockTypeMapper(BlockTypeUtils blockTypeUtils) {
        this.blockTypeUtils = blockTypeUtils;
    }

    public MaterialData map(BlockType type) {
        Material material = Material.getMaterial(type.getId());
        return new MaterialData(material, type.getData());
    }

    public BlockType map(Material material) {
        return blockTypeUtils.getType(material.getId(), 0);
    }

    public BlockType map(Material material, byte data) {
        return blockTypeUtils.getType(material.getId(), data);
    }
}
