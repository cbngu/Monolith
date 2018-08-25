package gg.warcraft.monolith.api.world.block.event;

import gg.warcraft.monolith.api.core.event.AbstractPreEvent;
import gg.warcraft.monolith.api.world.block.Block;

public abstract class AbstractBlockPreEvent extends AbstractPreEvent implements BlockPreEvent {
    private final Block block;

    public AbstractBlockPreEvent(Block block, boolean cancelled) {
        super(cancelled);
        this.block = block;
    }

    @Override
    public Block getBlock() {
        return block;
    }
}
