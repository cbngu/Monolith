package gg.warcraft.monolith.app.world.block.event;

import gg.warcraft.monolith.api.world.block.Block;
import gg.warcraft.monolith.api.world.block.event.AbstractBlockPreEvent;
import gg.warcraft.monolith.api.world.block.event.BlockPreGatheredEvent;

public class SimpleBlockPreGatheredEvent extends AbstractBlockPreEvent implements BlockPreGatheredEvent {

    public SimpleBlockPreGatheredEvent(Block block, boolean cancelled) {
        super(block, cancelled);
    }
}
