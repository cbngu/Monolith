package gg.warcraft.monolith.app.entity.event;

import gg.warcraft.monolith.api.entity.event.EntityEvent;

import java.util.UUID;

public class AbstractEntityEvent implements EntityEvent {
    private final UUID entityId;

    public AbstractEntityEvent(UUID entityId) {
        this.entityId = entityId;
    }

    @Override
    public UUID getEntityId() {
        return entityId;
    }
}
