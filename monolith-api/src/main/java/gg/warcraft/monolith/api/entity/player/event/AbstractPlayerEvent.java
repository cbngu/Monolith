package gg.warcraft.monolith.api.entity.player.event;

import java.util.UUID;

public abstract class AbstractPlayerEvent implements PlayerEvent {
    private final UUID playerId;

    public AbstractPlayerEvent(UUID playerId) {
        this.playerId = playerId;
    }

    @Override
    public UUID getPlayerId() {
        return playerId;
    }
}
