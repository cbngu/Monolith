package gg.warcraft.monolith.api.entity.event;

import gg.warcraft.monolith.api.core.event.AbstractPreEvent;
import gg.warcraft.monolith.api.entity.EntityType;

import java.util.UUID;

public abstract class AbstractEntityPreEvent extends AbstractPreEvent implements EntityPreEvent {
    private final UUID entityId;
    private final EntityType entityType;

    public AbstractEntityPreEvent(UUID entityId, EntityType entityType, boolean cancelled) {
        super(cancelled);
        this.entityId = entityId;
        this.entityType = entityType;
    }

    @Override
    public UUID getEntityId() {
        return entityId;
    }

    @Override
    public EntityType getEntityType() {
        return entityType;
    }
}
