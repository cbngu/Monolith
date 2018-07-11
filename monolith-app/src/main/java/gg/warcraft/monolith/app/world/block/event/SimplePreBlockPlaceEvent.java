package gg.warcraft.monolith.app.world.block.event;

import gg.warcraft.monolith.api.world.block.Block;
import gg.warcraft.monolith.api.world.block.BlockType;
import gg.warcraft.monolith.api.world.block.event.PreBlockPlaceEvent;

import java.util.UUID;

public class SimplePreBlockPlaceEvent extends SimplePreBlockEvent implements PreBlockPlaceEvent {
    private BlockType newType;
    private final UUID playerId;

    public SimplePreBlockPlaceEvent(Block block, BlockType newType, UUID playerId, boolean cancelled) {
        super(block, cancelled);
        this.newType = newType;
        this.playerId = playerId;
    }

    @Override
    public BlockType getNewType() {
        return newType;
    }

    @Override
    public void setNewType(BlockType type) {
        this.newType = type;
    }

    @Override
    public UUID getPlayerId() {
        return playerId;
    }
}
