package gg.warcraft.monolith.api.entity.attribute;

/**
 * An Attribute is a value, generally used in combat calculations, that denotes how proficient an {@code Entity} is in
 * the thing the attribute represents
 */
public interface Attribute {

    /**
     * @return The name of this attribute. Never null.
     */
    String getName();
}
