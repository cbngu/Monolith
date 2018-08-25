package gg.warcraft.monolith.app.entity.event;

import gg.warcraft.monolith.api.entity.EntityType;
import gg.warcraft.monolith.api.entity.event.AbstractEntityEvent;
import gg.warcraft.monolith.api.entity.event.EntityHealthChangedEvent;

import java.util.UUID;

public class SimpleEntityHealthChangedEvent extends AbstractEntityEvent implements EntityHealthChangedEvent {
    private final float previousHealth;
    private final float previousPercentHealth;
    private final float newHealth;
    private final float newPercentHealth;

    public SimpleEntityHealthChangedEvent(UUID entityId, EntityType entityType, float previousHealth,
                                          float previousPercentHealth, float newHealth, float newPercentHealth) {
        super(entityId, entityType);
        this.previousHealth = previousHealth;
        this.previousPercentHealth = previousPercentHealth;
        this.newHealth = newHealth;
        this.newPercentHealth = newPercentHealth;
    }

    @Override
    public float getPreviousHealth() {
        return previousHealth;
    }

    @Override
    public float getPreviousPercentHealth() {
        return previousPercentHealth;
    }

    @Override
    public float getNewHealth() {
        return newHealth;
    }

    @Override
    public float getNewPercentHealth() {
        return newPercentHealth;
    }
}
