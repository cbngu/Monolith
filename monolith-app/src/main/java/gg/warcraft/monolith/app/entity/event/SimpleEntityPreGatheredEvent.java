package gg.warcraft.monolith.app.entity.event;

import java.util.UUID;

import gg.warcraft.monolith.api.entity.EntityType;
import gg.warcraft.monolith.api.entity.event.AbstractEntityPreEvent;
import gg.warcraft.monolith.api.entity.event.EntityPreGatheredEvent;

public class SimpleEntityPreGatheredEvent extends AbstractEntityPreEvent implements EntityPreGatheredEvent {

    public SimpleEntityPreGatheredEvent(UUID entityId, EntityType entityType, boolean cancelled) {
        super(entityId, entityType, cancelled);
    }
}
