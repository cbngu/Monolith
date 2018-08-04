package gg.warcraft.monolith.app.entity.status;

import gg.warcraft.monolith.api.entity.status.StatusEffect;
import gg.warcraft.monolith.api.util.Duration;

import java.util.UUID;

public abstract class AbstractStatusEffect implements StatusEffect {
    private final UUID entityId;
    private final Duration duration;

    public AbstractStatusEffect(UUID entityId, Duration duration) {
        this.entityId = entityId;
        this.duration = duration;
    }

    @Override
    public UUID getEntityId() {
        return entityId;
    }

    @Override
    public Duration getDuration() {
        return duration;
    }
}
