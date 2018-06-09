package gg.warcraft.monolith.app.entity.status;

import gg.warcraft.monolith.api.entity.status.Status;
import gg.warcraft.monolith.api.entity.status.StatusEffect;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class SimpleStatus implements Status {
    private final UUID entityId;
    private final Set<StatusEffect> effects;

    public SimpleStatus(UUID entityId, Set<StatusEffect> effects) {
        this.entityId = entityId;
        this.effects = effects;
    }

    @Override
    public UUID getEntityId() {
        return entityId;
    }

    @Override
    public Set<StatusEffect> getEffects() {
        return new HashSet<>(effects);
    }
}
