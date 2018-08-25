package gg.warcraft.monolith.app.world.block.event;

import gg.warcraft.monolith.api.world.block.Block;
import gg.warcraft.monolith.api.world.block.event.AbstractBlockEvent;
import gg.warcraft.monolith.api.world.block.event.BlockPlaceEvent;

import java.util.UUID;

public class SimpleBlockPlaceEvent extends AbstractBlockEvent implements BlockPlaceEvent {
    private Block placedBlock;
    private Block placedAgainst;
    private final UUID playerId;

    public SimpleBlockPlaceEvent(Block block, Block placedBlock, Block placedAgainst, UUID playerId) {
        super(block);
        this.placedBlock = placedBlock;
        this.placedAgainst = placedAgainst;
        this.playerId = playerId;
    }

    @Override
    public Block getPlacedBlock() {
        return placedBlock;
    }

    @Override
    public Block getPlacedAgainst() {
        return placedAgainst;
    }

    @Override
    public UUID getPlayerId() {
        return playerId;
    }
}
