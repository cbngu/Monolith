package gg.warcraft.monolith.api.entity.attribute;

/**
 * An AttributeModifier is one of possibly many modifiers that make up an {@code Attribute} of an {@code Entity}.
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

    /**
     * @param observer The observer to add to this modifier. Can not be null.
     */
    void addObserver(AttributeModifier.Observer observer);

    /**
     * @param observer The observer to remove from this modifier. Can not be null.
     */
    void removeObserver(AttributeModifier.Observer observer);

    /**
     * AttributeModifier.Observer is a simple observer class that allows objects to subscribe to updates of the state of
     * an {@code AttributeModifier}.
     */
    interface Observer {

        /**
         * @param modifier The modifier that has changed. Can not be null.
         */
        void onChanged(AttributeModifier modifier);
    }
}
