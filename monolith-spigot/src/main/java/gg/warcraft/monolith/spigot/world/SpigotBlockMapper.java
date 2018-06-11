package gg.warcraft.monolith.spigot.world;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.world.BlockLocation;
import gg.warcraft.monolith.api.world.block.Block;
import gg.warcraft.monolith.api.world.block.BlockType;
import gg.warcraft.monolith.app.world.block.SimpleBlock;
import org.bukkit.Location;

public class SpigotBlockMapper {
    private final SpigotLocationMapper locationMapper;
    private final SpigotBlockTypeMapper blockTypeMapper;

    @Inject
    public SpigotBlockMapper(SpigotLocationMapper locationMapper, SpigotBlockTypeMapper blockTypeMapper) {
        this.locationMapper = locationMapper;
        this.blockTypeMapper = blockTypeMapper;
    }

    public org.bukkit.block.Block map(Block block) {
        Location spigotLocation = locationMapper.map(block.getLocation());
        return spigotLocation.getBlock();
    }

    public Block map(org.bukkit.block.Block block) {
        BlockType type = blockTypeMapper.map(block.getType(), block.getData());
        BlockLocation location = locationMapper.map(block);
        return new SimpleBlock(type, location);
    }
}
