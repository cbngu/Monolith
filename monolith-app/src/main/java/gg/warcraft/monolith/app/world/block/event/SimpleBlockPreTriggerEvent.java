package gg.warcraft.monolith.app.world.block.event;

import gg.warcraft.monolith.api.world.block.Block;
import gg.warcraft.monolith.api.world.block.event.AbstractBlockPreEvent;
import gg.warcraft.monolith.api.world.block.event.BlockPreTriggerEvent;

import java.util.UUID;

public class SimpleBlockPreTriggerEvent extends AbstractBlockPreEvent implements BlockPreTriggerEvent {
    private final UUID playerId;

    public SimpleBlockPreTriggerEvent(Block block, UUID playerId, boolean cancelled) {
        super(block, cancelled);
        this.playerId = playerId;
    }

    @Override
    public UUID getPlayerId() {
        return playerId;
    }
}
