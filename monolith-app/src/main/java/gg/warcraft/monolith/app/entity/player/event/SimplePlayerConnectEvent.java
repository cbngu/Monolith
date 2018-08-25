package gg.warcraft.monolith.app.entity.player.event;

import gg.warcraft.monolith.api.entity.player.event.AbstractPlayerEvent;
import gg.warcraft.monolith.api.entity.player.event.PlayerConnectEvent;

import java.util.UUID;

public class SimplePlayerConnectEvent extends AbstractPlayerEvent implements PlayerConnectEvent {

    public SimplePlayerConnectEvent(UUID playerId) {
        super(playerId);
    }
}
