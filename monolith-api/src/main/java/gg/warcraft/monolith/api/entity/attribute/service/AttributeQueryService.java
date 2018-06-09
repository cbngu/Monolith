package gg.warcraft.monolith.api.entity.attribute.service;

import gg.warcraft.monolith.api.entity.attribute.Attributes;

import java.util.UUID;

/**
 * This service is injectable.
 * <p>
 * The AttributeQueryService serves as a point of entry into the entity implementation. It provides a method to query
 * the {@code Attributes} of an {@code Entity}.
 */
public interface AttributeQueryService {

    /**
     * @param entityId The id of the entity. Can not be null.
     * @return The attributes of the entity. Can be null.
     */
    Attributes getAttributes(UUID entityId);
}
