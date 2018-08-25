package gg.warcraft.monolith.app.world.block.event;

import gg.warcraft.monolith.api.world.block.Block;
import gg.warcraft.monolith.api.world.block.event.AbstractBlockEvent;
import gg.warcraft.monolith.api.world.block.event.BlockTriggerEvent;

import java.util.UUID;

public class SimpleBlockTriggerEvent extends AbstractBlockEvent implements BlockTriggerEvent {
    private final UUID playerId;

    public SimpleBlockTriggerEvent(Block block, UUID playerId) {
        super(block);
        this.playerId = playerId;
    }

    @Override
    public UUID getPlayerId() {
        return playerId;
    }
}
