package gg.warcraft.monolith.api.world.block;

import gg.warcraft.monolith.api.world.Direction;
import gg.warcraft.monolith.api.world.location.BlockLocation;

public interface Gate extends DirectionalBlock {

    boolean isOpen();

    Gate withOpen(boolean open);

    @Override
    Gate withLocation(BlockLocation location);

    @Override
    Gate withFacing(Direction facing);
}
