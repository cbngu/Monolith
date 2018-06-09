package gg.warcraft.monolith.app.entity.player.event;

import gg.warcraft.monolith.api.entity.player.event.PlayerPreConnectEvent;

import java.util.UUID;

public class SimplePlayerPreConnectEvent extends SimplePlayerEvent implements PlayerPreConnectEvent {
    private final String name;

    public SimplePlayerPreConnectEvent(UUID playerId, String name) {
        super(playerId);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
