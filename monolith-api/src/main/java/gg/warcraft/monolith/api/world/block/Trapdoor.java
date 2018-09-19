package gg.warcraft.monolith.api.world.block;

import gg.warcraft.monolith.api.world.Direction;
import gg.warcraft.monolith.api.world.location.BlockLocation;

public interface Trapdoor extends DirectionalBlock {

    boolean isInverted();

    boolean isOpen();

    Trapdoor withInverted(boolean inverted);

    Trapdoor withOpen(boolean open);

    @Override
    Trapdoor withLocation(BlockLocation location);

    @Override
    Trapdoor withFacing(Direction facing);
}
