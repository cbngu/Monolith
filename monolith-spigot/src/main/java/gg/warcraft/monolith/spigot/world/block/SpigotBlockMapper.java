package gg.warcraft.monolith.spigot.world.block;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.world.Direction;
import gg.warcraft.monolith.api.world.block.Block;
import gg.warcraft.monolith.api.world.block.BlockType;
import gg.warcraft.monolith.api.world.location.BlockLocation;
import gg.warcraft.monolith.app.world.block.ChestBlock;
import gg.warcraft.monolith.app.world.block.SignBlock;
import gg.warcraft.monolith.app.world.block.SimpleBlock;
import gg.warcraft.monolith.spigot.world.SpigotDirectionMapper;
import gg.warcraft.monolith.spigot.world.location.SpigotLocationMapper;
import org.bukkit.Location;
import org.bukkit.block.Sign;
import org.bukkit.material.Chest;

public class SpigotBlockMapper {
    private final SpigotLocationMapper locationMapper;
    private final SpigotBlockTypeMapper blockTypeMapper;
    private final SpigotBlockFaceMapper blockFaceMapper;
    private final SpigotDirectionMapper directionMapper;

    @Inject
    public SpigotBlockMapper(SpigotLocationMapper locationMapper, SpigotBlockTypeMapper blockTypeMapper,
                             SpigotBlockFaceMapper blockFaceMapper, SpigotDirectionMapper directionMapper) {
        this.locationMapper = locationMapper;
        this.blockTypeMapper = blockTypeMapper;
        this.blockFaceMapper = blockFaceMapper;
        this.directionMapper = directionMapper;
    }

    public org.bukkit.block.Block map(Block block) {
        Location spigotLocation = locationMapper.map(block.getLocation());
        return spigotLocation.getBlock();
    }

    public Block map(org.bukkit.block.Block block) {
        if (block == null) {
            return null;
        }

        BlockType type = blockTypeMapper.map(block.getType(), block.getData());
        BlockLocation location = locationMapper.map(block);
        switch (block.getType()) {
            case SIGN_POST:
            case WALL_SIGN:
                Sign sign = (Sign) block.getState();
                org.bukkit.material.Sign signMaterial = (org.bukkit.material.Sign) sign.getData();
                Direction facing = directionMapper.map(signMaterial.getFacing());
                org.bukkit.block.Block spigotAttachedBlock = block.getRelative(signMaterial.getAttachedFace());
                Block attachedBlock = map(spigotAttachedBlock);
                String[] lines = sign.getLines();
                return new SignBlock(type, location, facing, attachedBlock, lines);
            case CHEST:
                Chest chest = (Chest) block.getState().getData();
                Direction direction = directionMapper.map(chest.getFacing());
                return new ChestBlock(type, location, direction);
            default:
                return new SimpleBlock(type, location);
        }
    }
}
