package gg.warcraft.monolith.api.entity.event;

import gg.warcraft.monolith.api.core.PreEvent;
import gg.warcraft.monolith.api.entity.EntityType;

import java.util.UUID;

public interface EntityPreEvent extends PreEvent {

    /**
     * @return The id of the entity. Never null.
     */
    UUID getEntityId();

    /**
     * @return The type of the entity. Never null.
     */
    EntityType getEntityType();
}
