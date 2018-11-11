package gg.warcraft.monolith.app.world.block;

import gg.warcraft.monolith.api.world.block.BlockType;
import gg.warcraft.monolith.api.world.block.Door;
import gg.warcraft.monolith.api.world.location.BlockLocation;

public class DoorBlock extends SimpleBlock implements Door {
    private final boolean isOpen;

    public DoorBlock(BlockType type, BlockLocation location, boolean isOpen) {
        super(type, location);
        this.isOpen = isOpen;
    }

    @Override
    public boolean isOpen() {
        return isOpen;
    }

    @Override
    public Door withOpen(boolean open) {
        return new DoorBlock(getType(), getLocation(), isOpen);
    }

    @Override
    public Door withLocation(BlockLocation location) {
        return new DoorBlock(getType(), location, isOpen());
    }
}
