package gg.warcraft.monolith.api.entity.event;

import gg.warcraft.monolith.api.entity.EntityType;

import java.util.UUID;

public abstract class AbstractEntityEvent implements EntityEvent {
    private final UUID entityId;
    private final EntityType entityType;

    public AbstractEntityEvent(UUID entityId, EntityType entityType) {
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
