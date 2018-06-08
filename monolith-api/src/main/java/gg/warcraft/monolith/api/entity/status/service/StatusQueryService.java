package gg.warcraft.monolith.api.entity.status.service;

import gg.warcraft.monolith.api.entity.status.Status;

import java.util.UUID;

/**
 * This service is injectable.
 * <p>
 * The StatusQueryService serves as a point of entry into the entity implementation. It provides a method to query the
 * current {@code Status} of an {@code Entity}.
 */
public interface StatusQueryService {

    /**
     * @param entityId The id of the entity.
     * @return The current status of the entity. Never null.
     */
    Status getStatus(UUID entityId);
}
