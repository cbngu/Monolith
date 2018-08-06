package gg.warcraft.monolith.api.entity.status.service;

import gg.warcraft.monolith.api.entity.status.Status;

import java.util.UUID;

/**
 * This repository is injectable, however you generally have no need for it. Use the command and query services instead.
 * <p>
 * If you feel you absolutely have to use this repository it can be used to forgo the command service and save a {@code
 * Status} to the Monolith domain directly. This repository does no safety checks whatsoever.
 */
public interface StatusRepository {

    /**
     * @param entityId The id of the entity. Can not be null.
     * @return The status of the entity. Never null.
     */
    Status getStatus(UUID entityId);

    /**
     * @param status The status to save. Can not be null.
     */
    void save(Status status);

    /**
     * @param entityId The id of the entity. Can not be null.
     */
    void delete(UUID entityId);
}
