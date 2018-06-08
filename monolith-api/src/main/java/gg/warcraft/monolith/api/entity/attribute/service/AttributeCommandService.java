package gg.warcraft.monolith.api.entity.attribute.service;

import gg.warcraft.monolith.api.entity.attribute.AttributeModifier;

import java.util.UUID;

/**
 * This service is injectable.
 * <p>
 * The AttributeCommandService serves as a point of entry into the entity module implementation. It provides methods to
 * add and remove an {@code AttributeModifier} to or from an {@code Entity}.
 */
public interface AttributeCommandService {

    /**
     * @param modifier The attribute modifier to add to the entity. Can not be null.
     * @param entityId The id of the entity. Can not be null.
     */
    void addAttributeModifier(AttributeModifier modifier, UUID entityId);

    /**
     * @param modifier The modifier to remove from the entity. Can not be null.
     * @param entityId The id of the entity. Can not be null.
     */
    void removeAttributeModifier(AttributeModifier modifier, UUID entityId);
}
