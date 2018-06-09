package gg.warcraft.monolith.app.entity.player.event;

import gg.warcraft.monolith.api.entity.player.event.PlayerDisconnectEvent;

import java.util.UUID;

public class SimplePlayerDisconnectEvent extends SimplePlayerEvent implements PlayerDisconnectEvent {

    public SimplePlayerDisconnectEvent(UUID playerId) {
        super(playerId);
    }
}
