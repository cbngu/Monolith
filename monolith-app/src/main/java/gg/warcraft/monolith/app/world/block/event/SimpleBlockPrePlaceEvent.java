package gg.warcraft.monolith.app.world.block.event;

import gg.warcraft.monolith.api.world.block.Block;
import gg.warcraft.monolith.api.world.block.BlockType;
import gg.warcraft.monolith.api.world.block.event.BlockPrePlaceEvent;

import java.util.UUID;

public class SimpleBlockPrePlaceEvent extends SimpleBlockPreEvent implements BlockPrePlaceEvent {
    private Block placedBlock;
    private Block placedAgainst;
    private final UUID playerId;

    public SimpleBlockPrePlaceEvent(Block block, Block placedBlock, Block placedAgainst, UUID playerId,
                                    boolean cancelled) {
        super(block, cancelled);
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

    @Override
    public void setPlacedBlockType(BlockType type) {
        // TODO
        throw new IllegalStateException("not implemented");
    }
}
