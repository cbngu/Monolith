package gg.warcraft.monolith.app.world.block.event;

import java.util.UUID;

import gg.warcraft.monolith.api.world.block.Block;
import gg.warcraft.monolith.api.world.block.event.AbstractBlockEvent;
import gg.warcraft.monolith.api.world.block.event.BlockGatheredEvent;

public class SimpleBlockGatheredEvent extends AbstractBlockEvent implements BlockGatheredEvent {

    public SimpleBlockGatheredEvent(Block block) {
        super(block);
    }
}
