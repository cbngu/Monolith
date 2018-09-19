package gg.warcraft.monolith.api.world.block;

import gg.warcraft.monolith.api.world.Direction;
import gg.warcraft.monolith.api.world.location.BlockLocation;

public interface Chest extends DirectionalBlock {

    @Override
    Chest withLocation(BlockLocation location);

    @Override
    Chest withFacing(Direction facing);
}
