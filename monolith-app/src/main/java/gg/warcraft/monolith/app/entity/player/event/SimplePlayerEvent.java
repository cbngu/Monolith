package gg.warcraft.monolith.app.entity.player.event;

import gg.warcraft.monolith.api.entity.player.event.PlayerEvent;

import java.util.UUID;

public class SimplePlayerEvent implements PlayerEvent {
    private final UUID playerId;

    public SimplePlayerEvent(UUID playerId) {
        this.playerId = playerId;
    }

    @Override
    public UUID getPlayerId() {
        return playerId;
    }
}
