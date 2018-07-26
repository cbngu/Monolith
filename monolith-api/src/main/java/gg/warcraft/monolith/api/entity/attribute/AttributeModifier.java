package gg.warcraft.monolith.api.entity.attribute;

/**
 * An AttributeModifier is one of possibly many modifiers that make up an {@code Attribute} of an {@code Entity}.
 * Attribute modifiers are saved by reference, meaning that changing the value of a modifier after it has been added to
 * an {@code Entity} via the {@code AttributeCommandService} will instantly reflect in calls to {@code
 * AttributeQueryService}.
 */
public interface AttributeModifier {

    /**
     * @return The attribute this modifier belongs to. Never null.
     */
    Attribute getAttribute();

    /**
     * @return The current value of this modifier.
     */
    float getValue();

    /**
     * @param value The value to set this modifier to.
     */
    void setValue(float value);
}
