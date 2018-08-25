package gg.warcraft.monolith.app.entity.event;

import gg.warcraft.monolith.api.entity.EntityType;
import gg.warcraft.monolith.api.entity.event.AbstractEntityPreEvent;
import gg.warcraft.monolith.api.entity.event.EntityPreFatalDamageEvent;

import java.util.UUID;

public class SimpleEntityPreFatalDamageEvent extends AbstractEntityPreEvent implements EntityPreFatalDamageEvent {

    public SimpleEntityPreFatalDamageEvent(UUID entityId, EntityType entityType, boolean cancelled) {
        super(entityId, entityType, cancelled);
    }
}
