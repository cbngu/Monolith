package gg.warcraft.monolith.app.entity.attribute;

import gg.warcraft.monolith.api.entity.attribute.Attribute;
import gg.warcraft.monolith.api.entity.attribute.AttributeModifier;

import java.util.HashSet;
import java.util.Set;

public class SimpleAttributeModifier implements AttributeModifier {
    private final Attribute attribute;
    private final Set<Observer> observers;

    private float value;

    public SimpleAttributeModifier(Attribute attribute, float value) {
        this.attribute = attribute;
        this.observers = new HashSet<>();
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
        observers.forEach(observer -> observer.onChange(this));
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
}
