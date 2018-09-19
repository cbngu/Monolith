package gg.warcraft.monolith.api.world.block;

import gg.warcraft.monolith.api.world.Direction;
import gg.warcraft.monolith.api.world.location.BlockLocation;

public interface Lever extends DirectionalBlock {

    boolean isPowered();

    Lever withPowered(boolean powered);

    @Override
    Lever withLocation(BlockLocation location);

    @Override
    Lever withFacing(Direction facing);
}
