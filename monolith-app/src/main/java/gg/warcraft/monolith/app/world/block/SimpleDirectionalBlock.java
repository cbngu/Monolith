package gg.warcraft.monolith.app.world.block;

import gg.warcraft.monolith.api.world.Direction;
import gg.warcraft.monolith.api.world.block.BlockType;
import gg.warcraft.monolith.api.world.block.DirectionalBlock;
import gg.warcraft.monolith.api.world.location.BlockLocation;

public class SimpleDirectionalBlock extends SimpleBlock implements DirectionalBlock {
    private final Direction facing;

    public SimpleDirectionalBlock(BlockType type, BlockLocation location, Direction facing) {
        super(type, location);
        this.facing = facing;
    }

    @Override
    public Direction getFacing() {
        return facing;
    }
}
