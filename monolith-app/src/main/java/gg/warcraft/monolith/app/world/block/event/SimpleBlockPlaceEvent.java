package gg.warcraft.monolith.app.world.block.event;

import gg.warcraft.monolith.api.world.block.Block;
import gg.warcraft.monolith.api.world.block.BlockType;
import gg.warcraft.monolith.api.world.block.event.BlockPlaceEvent;

public class SimpleBlockPlaceEvent extends SimpleBlockEvent implements BlockPlaceEvent {
    private final BlockType newType;

    public SimpleBlockPlaceEvent(Block block, BlockType newType) {
        super(block);
        this.newType = newType;
    }

    @Override
    public BlockType getNewType() {
        return newType;
    }
}
