package gg.warcraft.monolith.app.entity.event;

import gg.warcraft.monolith.api.entity.event.EntityPreFatalDamageEvent;

import java.util.UUID;

public class SimpleEntityPreFatalDamageEvent extends SimpleEntityPreEvent implements EntityPreFatalDamageEvent {

    public SimpleEntityPreFatalDamageEvent(UUID entityId, boolean cancelled) {
        super(entityId, cancelled);
    }
}
