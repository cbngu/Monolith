package gg.warcraft.monolith.api.world.block;

import gg.warcraft.monolith.api.world.Direction;

public interface DirectionalBlock extends Block {

    /**
     * @return The direction this block is facing. Never null.
     */
    Direction getFacing();
}
