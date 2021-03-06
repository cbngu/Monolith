package gg.warcraft.monolith.api.entity.event;

import gg.warcraft.monolith.api.core.Event;
import gg.warcraft.monolith.api.entity.EntityType;

import java.util.UUID;

/**
 * EntityEvent is a utility interface to group all entity related events together.
 */
public interface EntityEvent extends Event {

    /**
     * @return The id of the entity. Never null.
     */
    UUID getEntityId();

    /**
     * @return The type of the entity. Never null.
     */
    EntityType getEntityType();
}
