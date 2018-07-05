package gg.warcraft.monolith.api.world.block;

import gg.warcraft.monolith.api.world.Direction;

public interface Chest extends Block {

    /**
     * @return The direction this chest is facing in. Never null or UP or DOWN.
     */
    Direction getFacing();
}
