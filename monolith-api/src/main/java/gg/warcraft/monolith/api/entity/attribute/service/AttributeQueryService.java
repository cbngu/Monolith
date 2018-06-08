package gg.warcraft.monolith.api.entity.attribute.service;

import gg.warcraft.monolith.api.entity.attribute.Attribute;

import java.util.UUID;

/**
 * This service is injectable.
 * <p>
 * The AttributeQueryService serves as a point of entry into the entity implementation. It provides a method to query
 * the current value of an {@code Attribute} of an {@code Entity}.
 */
public interface AttributeQueryService {

    /**
     * @param attribute The attribute. Can not be null.
     * @param entityId  The id of the entity. Can not be null.
     * @return The value created by adding all modifiers of this attribute currently registered to the entity together.
     */
    float getAttributeValue(Attribute attribute, UUID entityId);
}
