package gg.warcraft.monolith.app.world.block.event;

import gg.warcraft.monolith.api.world.block.Block;
import gg.warcraft.monolith.api.world.block.BlockType;
import gg.warcraft.monolith.api.world.block.event.BlockPlaceEvent;

import java.util.UUID;

public class SimpleBlockPlaceEvent extends SimpleBlockEvent implements BlockPlaceEvent {
    private final BlockType newType;
    private final UUID playerId;

    public SimpleBlockPlaceEvent(Block block, BlockType newType, UUID playerId) {
        super(block);
        this.newType = newType;
        this.playerId = playerId;
    }

    @Override
    public BlockType getNewType() {
        return newType;
    }

    @Override
    public UUID getPlayerId() {
        return playerId;
    }
}
