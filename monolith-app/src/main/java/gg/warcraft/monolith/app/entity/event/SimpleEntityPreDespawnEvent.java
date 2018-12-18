package gg.warcraft.monolith.app.entity.event;

import gg.warcraft.monolith.api.entity.EntityType;
import gg.warcraft.monolith.api.entity.event.AbstractEntityPreEvent;
import gg.warcraft.monolith.api.entity.event.EntityPreDespawnEvent;

import java.util.UUID;

public class SimpleEntityPreDespawnEvent extends AbstractEntityPreEvent implements EntityPreDespawnEvent {

    public SimpleEntityPreDespawnEvent(UUID entityId, EntityType entityType, boolean cancelled) {
        super(entityId, entityType, cancelled);
    }
}
