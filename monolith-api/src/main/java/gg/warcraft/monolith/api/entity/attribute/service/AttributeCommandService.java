package gg.warcraft.monolith.api.entity.attribute.service;

import gg.warcraft.monolith.api.entity.attribute.Attribute;
import gg.warcraft.monolith.api.entity.attribute.AttributeModifier;
import gg.warcraft.monolith.api.entity.attribute.GenericAttribute;

import java.util.UUID;

/**
 * This service is injectable.
 * <p>
 * The AttributeCommandService serves as a point of entry into the entity module implementation. It provides methods to
 * add and remove an {@code AttributeModifier} to or from an {@code Entity}.
 */
public interface AttributeCommandService {

    /**
     * @param entityId     The id of the entity. Can not be null.
     * @param attribute    The attribute of the modifier. Can not be null.
     * @param initialValue The initial value of the modifier.
     * @return The new attribute modifier. Never null.
     */
    AttributeModifier addAttributeModifier(UUID entityId, Attribute attribute, float initialValue);

    /**
     * @param entityId The id of the entity. Can not be null.
     * @param modifier The modifier to remove from the entity. Can not be null.
     */
    void removeAttributeModifier(UUID entityId, AttributeModifier modifier);

    /**
     * @param entityId  The id of the entity. Can not be null.
     * @param attribute The generic attribute to force an update for. Can not be null.
     */
    void updateGenericAttribute(UUID entityId, GenericAttribute attribute);
}
