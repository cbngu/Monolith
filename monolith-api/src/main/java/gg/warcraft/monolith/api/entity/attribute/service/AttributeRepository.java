package gg.warcraft.monolith.api.entity.attribute.service;

import gg.warcraft.monolith.api.entity.attribute.Attributes;

import java.util.UUID;

/**
 * This repository is injectable, however you generally have no need for it. Use the command and query services instead.
 * <p>
 * If you feel you absolutely have to use this repository it can be used to forgo the command service and save an {@code
 * AttributeModifier} to the Monolith domain directly. This repository does no safety checks whatsoever.
 */
public interface AttributeRepository {

    /**
     * @param entityId The id of the entity. Can not be null.
     * @return The attributes of the entity. Never null.
     */
    Attributes getAttributes(UUID entityId);

    /**
     * @param attributes The attributes to save. Can not be null.
     */
    void save(Attributes attributes);
}
