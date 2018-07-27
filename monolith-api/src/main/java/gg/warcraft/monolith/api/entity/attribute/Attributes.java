package gg.warcraft.monolith.api.entity.attribute;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * Attributes represent the state of all attribute modifiers currently attached to an entity.
 */
public interface Attributes extends AttributeModifier.Observer {

    /**
     * @return The id of the entity this attributes belongs to. Never null.
     */
    UUID getEntityId();

    /**
     * @return All attribute modifiers in this attributes. Never null, but can be empty. Items are never null.
     */
    Map<Attribute, Set<AttributeModifier>> getModifiers();

    /**
     * @param attribute The attribute. Can not be null.
     * @return All attribute modifiers of the attribute in this attributes. Never null, but can be empty. Items are
     * never null.
     */
    Set<AttributeModifier> getModifiers(Attribute attribute);

    /**
     * @param attribute The attribute. Can not be null.
     * @return The value of the attribute for the entity.
     */
    float getValue(Attribute attribute);
}
