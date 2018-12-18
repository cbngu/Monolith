package gg.warcraft.monolith.app.entity.event;

import gg.warcraft.monolith.api.entity.EntityType;
import gg.warcraft.monolith.api.entity.event.AbstractEntityPreEvent;
import gg.warcraft.monolith.api.entity.event.EntityPreRespawnEvent;

import java.util.UUID;

public class SimpleEntityPreRespawnEvent extends AbstractEntityPreEvent implements EntityPreRespawnEvent {

    public SimpleEntityPreRespawnEvent(UUID entityId, EntityType entityType, boolean cancelled) {
        super(entityId, entityType, cancelled);
    }
}
