package gg.warcraft.monolith.app.entity.event;

import gg.warcraft.monolith.api.entity.event.EntityHealthChangedEvent;

import java.util.UUID;

public class SimpleEntityHealthChangedEvent extends SimpleEntityEvent implements EntityHealthChangedEvent {
    private final float previousHealth;
    private final float newHealth;

    public SimpleEntityHealthChangedEvent(UUID entityId, float previousHealth, float newHealth) {
        super(entityId);
        this.previousHealth = previousHealth;
        this.newHealth = newHealth;
    }

    @Override
    public float getPreviousHealth() {
        return previousHealth;
    }

    @Override
    public float getNewHealth() {
        return newHealth;
    }
}
