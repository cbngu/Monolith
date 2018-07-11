package gg.warcraft.monolith.app.world.block.event;

import gg.warcraft.monolith.api.world.block.Block;
import gg.warcraft.monolith.api.world.block.event.PreBlockEvent;
import gg.warcraft.monolith.app.core.SimplePreEvent;

public class SimplePreBlockEvent extends SimplePreEvent implements PreBlockEvent {
    private final Block block;

    public SimplePreBlockEvent(Block block, boolean cancelled) {
        super(cancelled);
        this.block = block;
    }

    @Override
    public Block getBlock() {
        return block;
    }
}
