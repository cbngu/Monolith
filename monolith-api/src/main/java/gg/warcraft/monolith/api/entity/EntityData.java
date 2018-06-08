package gg.warcraft.monolith.api.entity;

import java.util.UUID;

/**
 * EntityData represents the custom data associated with an {@code Entity}.
 */
public interface EntityData {

    /**
     * @return The id of the entity this data belongs to. Never null.
     */
    UUID getEntityId();

    /**
     * @return The faction of the entity this data belongs to. Can be null.
     */
    Faction getFaction();
}
