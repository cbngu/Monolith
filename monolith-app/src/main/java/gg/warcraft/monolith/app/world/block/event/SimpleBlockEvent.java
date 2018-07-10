package gg.warcraft.monolith.app.world.block.event;

import gg.warcraft.monolith.api.world.block.Block;
import gg.warcraft.monolith.api.world.block.event.BlockEvent;

public class SimpleBlockEvent implements BlockEvent {
    private final Block block;

    public SimpleBlockEvent(Block block) {
        this.block = block;
    }

    @Override
    public Block getBlock() {
        return block;
    }
}
