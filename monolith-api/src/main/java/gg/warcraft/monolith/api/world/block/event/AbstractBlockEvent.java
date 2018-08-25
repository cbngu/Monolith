package gg.warcraft.monolith.api.world.block.event;

import gg.warcraft.monolith.api.world.block.Block;

public abstract class AbstractBlockEvent implements BlockEvent {
    private final Block block;

    public AbstractBlockEvent(Block block) {
        this.block = block;
    }

    @Override
    public Block getBlock() {
        return block;
    }
}
