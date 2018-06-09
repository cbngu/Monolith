package gg.warcraft.monolith.spigot.world;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.world.block.Block;
import gg.warcraft.monolith.app.world.block.SimpleBlock;

public class SpigotBlockMapper {
    private final SpigotLocationMapper locationMapper;
    private final SpigotBlockTypeMapper blockTypeMapper;

    @Inject
    public SpigotBlockMapper(SpigotLocationMapper locationMapper, SpigotBlockTypeMapper blockTypeMapper) {
        this.locationMapper = locationMapper;
        this.blockTypeMapper = blockTypeMapper;
    }

    public org.bukkit.block.Block map(Block block) {
        var spigotLocation = locationMapper.map(block.getLocation());
        return spigotLocation.getBlock();
    }

    public Block map(org.bukkit.block.Block block) {
        var type = blockTypeMapper.map(block.getType(), block.getData());
        var location = locationMapper.map(block);
        return new SimpleBlock(type, location);
    }
}
