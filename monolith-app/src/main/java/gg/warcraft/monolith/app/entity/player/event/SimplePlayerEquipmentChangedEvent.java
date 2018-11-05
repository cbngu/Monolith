package gg.warcraft.monolith.app.entity.player.event;

import gg.warcraft.monolith.api.entity.player.event.AbstractPlayerEvent;
import gg.warcraft.monolith.api.entity.player.event.PlayerEquipmentChangedEvent;

import java.util.UUID;

public class SimplePlayerEquipmentChangedEvent extends AbstractPlayerEvent implements PlayerEquipmentChangedEvent {

    public SimplePlayerEquipmentChangedEvent(UUID playerId) {
        super(playerId);
    }
}
