package gg.warcraft.monolith.api.world.block;

import gg.warcraft.monolith.api.world.location.BlockLocation;

public interface Door extends Block {

    boolean isOpen();

    Door withOpen(boolean open);

    @Override
    Door withLocation(BlockLocation location);
}
