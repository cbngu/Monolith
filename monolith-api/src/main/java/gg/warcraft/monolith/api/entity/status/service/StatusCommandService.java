package gg.warcraft.monolith.api.entity.status.service;

import gg.warcraft.monolith.api.entity.status.StatusEffect;

import java.util.UUID;

/**
 * This service is injectable.
 * <p>
 * The StatusCommandService serves as a point of entry into the entity module implementation. It provides methods to
 * add and remove a {@code StatusEffect} to or from an {@code Entity}.
 */
public interface StatusCommandService {

    /**
     * @param effect   The effect to add to the entity. Can not be null.
     * @param entityId The id of the entity. Can not be null.
     */
    void addStatusEffect(StatusEffect effect, UUID entityId);

    /**
     * @param effect   The effect to remove from the entity. Can not be null.
     * @param entityId The id of the entity. Can not be null.
     */
    void removeStatusEffect(StatusEffect effect, UUID entityId);
}
