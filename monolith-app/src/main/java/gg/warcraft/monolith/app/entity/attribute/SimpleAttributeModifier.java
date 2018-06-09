package gg.warcraft.monolith.app.entity.attribute;

import gg.warcraft.monolith.api.entity.attribute.Attribute;
import gg.warcraft.monolith.api.entity.attribute.AttributeModifier;

public class SimpleAttributeModifier implements AttributeModifier {
    private final Attribute attribute;
    private float value;

    public SimpleAttributeModifier(Attribute attribute, float value) {
        this.attribute = attribute;
        this.value = value;
    }

    @Override
    public Attribute getAttribute() {
        return attribute;
    }

    @Override
    public float getValue() {
        return value;
    }

    @Override
    public void setValue(float value) {
        this.value = value;
    }
}
