package gg.warcraft.monolith.api.entity.event;

public interface EntityHealthChangedEvent extends EntityEvent {

    float getPreviousHealth();

    float getPreviousPercentHealth();

    float getNewHealth();

    float getNewPercentHealth();
}
