package gg.warcraft.monolith.app.world.block;

import gg.warcraft.monolith.api.world.Direction;
import gg.warcraft.monolith.api.world.block.BlockType;
import gg.warcraft.monolith.api.world.block.Chest;
import gg.warcraft.monolith.api.world.location.BlockLocation;

public class ChestBlock extends SimpleBlock implements Chest {
    private final Direction facing;

    public ChestBlock(BlockType type, BlockLocation location, Direction facing) {
        super(type, location);
        this.facing = facing;
    }

    @Override
    public Direction getFacing() {
        return facing;
    }
}
