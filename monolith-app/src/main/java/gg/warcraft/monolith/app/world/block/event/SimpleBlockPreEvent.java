package gg.warcraft.monolith.app.world.block.event;

import gg.warcraft.monolith.api.world.block.Block;
import gg.warcraft.monolith.api.world.block.event.BlockPreEvent;
import gg.warcraft.monolith.app.core.SimplePreEvent;

public class SimpleBlockPreEvent extends SimplePreEvent implements BlockPreEvent {
    private final Block block;

    public SimpleBlockPreEvent(Block block, boolean cancelled) {
        super(cancelled);
        this.block = block;
    }

    @Override
    public Block getBlock() {
        return block;
    }
}
