package gg.warcraft.monolith.api.entity.attribute;

/**
 * An Attribute is a value, generally used in combat calculations, that denotes how proficient an {@code Entity} is in
 * the thing the attribute represents.
 * <p>
 * ! Many implementations depend on this interface only being implemented by enums.
 */
public interface Attribute {

    /**
     * @return The id of this attribute that will be used for equality checking. Never null or empty.
     */
    String getId();

    /**
     * @return The name of this attribute. Never null or empty.
     */
    String getName();
}
