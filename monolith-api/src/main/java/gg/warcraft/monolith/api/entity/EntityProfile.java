package gg.warcraft.monolith.api.entity;

import java.util.Map;
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
     * @return The persisted data of the entity. Never null, but can be empty.
     */
    Map<String, String> getData();
}
