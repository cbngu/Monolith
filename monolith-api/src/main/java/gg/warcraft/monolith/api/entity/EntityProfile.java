package gg.warcraft.monolith.api.entity;

import java.util.UUID;

/**
 * EntityProfile represents the custom data associated with an {@code Entity}.
 */
public interface EntityProfile {

    /**
     * @return The id of the entity. Never null.
     */
    UUID getEntityId();

    /**
     * @return The team of the entity. Can be null.
     */
    Team getTeam();
}
