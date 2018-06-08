package gg.warcraft.monolith.api.entity.status;

import java.util.Set;
import java.util.UUID;

/**
 * A Status represents all {@code StatusEffect}s that currently affect an {@code Entity}.
 */
public interface Status {

    /**
     * @return The id of the entity this status belongs to. Never null.
     */
    UUID getEntityId();

    /**
     * @return All active status effects in this status. Never null, but can be empty. Items are never null.
     */
    Set<StatusEffect> getEffects();
}
