package gg.warcraft.monolith.api.world.block;

import gg.warcraft.monolith.api.world.Direction;
import gg.warcraft.monolith.api.world.location.BlockLocation;

public interface Door extends DirectionalBlock {

    Hinge getHinge();

    boolean isOpen();

    boolean isTopHalf();

    Door withHinge(Hinge hinge);

    Door withOpen(boolean open);

    @Override
    Door withFacing(Direction facing);

    @Override
    Door withLocation(BlockLocation location);
}
