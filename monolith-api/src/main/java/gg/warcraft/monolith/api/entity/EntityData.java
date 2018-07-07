package gg.warcraft.monolith.api.entity;

import java.util.UUID;

/**
 * EntityData represents the custom data associated with an {@code Entity}.
 */
public interface EntityData {

    /**
     * @return The id of the entity. Never null.
     */
    UUID getEntityId();

    /**
     * @return The team of the entity. Can be null.
     */
    Team getTeam();
}
