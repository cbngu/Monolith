package gg.warcraft.monolith.api.entity.attribute;

/**
 * An Attribute is a value, generally used in combat calculations, that denotes how proficient an {@code Entity} is in
 * the thing the attribute represents.
 * <p>
 * ! Much of the implementation relies on this interface only being implemented by enums.
 */
public interface Attribute {

    /**
     * @return The name of this attribute. Never null or empty.
     */
    String getName();
}
