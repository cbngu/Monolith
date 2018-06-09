package gg.warcraft.monolith.app.entity.attribute;

import gg.warcraft.monolith.api.entity.attribute.Attribute;
import gg.warcraft.monolith.api.entity.attribute.AttributeModifier;
import gg.warcraft.monolith.api.entity.attribute.Attributes;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class SimpleAttributes implements Attributes {
    private final UUID entityId;
    private final Map<Attribute, Set<AttributeModifier>> modifiers;

    public SimpleAttributes(UUID entityId) {
        this(entityId, new HashMap<>());
    }

    public SimpleAttributes(UUID entityId, Map<Attribute, Set<AttributeModifier>> modifiers) {
        this.entityId = entityId;
        this.modifiers = modifiers;
    }

    @Override
    public UUID getEntityId() {
        return entityId;
    }

    @Override
    public Map<Attribute, Set<AttributeModifier>> getModifiers() {
        return new HashMap<>(modifiers);
    }

    @Override
    public Set<AttributeModifier> getModifiers(Attribute attribute) {
        var attributeModifiers = modifiers.computeIfAbsent(attribute, key -> Set.of());
        return Set.copyOf(attributeModifiers);
    }

    @Override
    public float getValue(Attribute attribute) {
        return getModifiers(attribute).stream()
                .map(AttributeModifier::getValue)
                .reduce(Float::sum)
                .orElse(0f);
    }
}
