package gg.warcraft.monolith.api.entity.status;

import gg.warcraft.monolith.api.util.Duration;

import java.util.UUID;

public abstract class AbstractStatusEffect implements StatusEffect {
    private final UUID entityId;
    private final String name;
    private final String type;
    private final Duration duration;

    public AbstractStatusEffect(UUID entityId, String name, Duration duration) {
        this(entityId, name, null, duration);
    }

    public AbstractStatusEffect(UUID entityId, String name, String type, Duration duration) {
        this.entityId = entityId;
        this.name = name;
        this.type = type;
        this.duration = duration;
    }

    @Override
    public UUID getEntityId() {
        return entityId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public Duration getDuration() {
        return duration;
    }
}
