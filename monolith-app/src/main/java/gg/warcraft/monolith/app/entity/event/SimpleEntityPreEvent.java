package gg.warcraft.monolith.app.entity.event;

import gg.warcraft.monolith.api.entity.event.EntityPreEvent;
import gg.warcraft.monolith.app.core.SimplePreEvent;

import java.util.UUID;

public class SimpleEntityPreEvent extends SimplePreEvent implements EntityPreEvent {
    private final UUID entityId;

    public SimpleEntityPreEvent(UUID entityId, boolean cancelled) {
        super(cancelled);
        this.entityId = entityId;
    }

    @Override
    public UUID getEntityId() {
        return entityId;
    }
}
