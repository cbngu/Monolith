package gg.warcraft.monolith.api.entity;

import java.util.UUID;

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
