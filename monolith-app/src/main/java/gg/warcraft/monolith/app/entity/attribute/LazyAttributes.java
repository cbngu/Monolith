package gg.warcraft.monolith.app.entity.attribute;

import gg.warcraft.monolith.api.entity.attribute.Attribute;
import gg.warcraft.monolith.api.entity.attribute.AttributeModifier;
import gg.warcraft.monolith.api.entity.attribute.Attributes;
import gg.warcraft.monolith.api.entity.attribute.GenericAttribute;
import gg.warcraft.monolith.api.entity.attribute.service.AttributeCommandService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class LazyAttributes implements Attributes {
    private final AttributeCommandService attributeCommandService;
    private final UUID entityId;
    private final Map<Attribute, Set<AttributeModifier>> modifiers;
    private final Map<Attribute, Float> attributes;

    public LazyAttributes(AttributeCommandService attributeCommandService,
                          UUID entityId, Map<Attribute, Set<AttributeModifier>> modifiers) {
        this.attributeCommandService = attributeCommandService;
        this.entityId = entityId;
        this.modifiers = modifiers;
        this.attributes = new HashMap<>();
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
        Set<AttributeModifier> attributeModifiers = modifiers.computeIfAbsent(attribute, key -> new HashSet<>());
        return new HashSet<>(attributeModifiers);
    }

    @Override
    public float getValue(Attribute attribute) {
        return attributes.computeIfAbsent(attribute, key -> getModifiers(attribute).stream()
                .map(AttributeModifier::getValue)
                .reduce(Float::sum)
                .orElse(0f));
    }

    @Override
    public void onChange(AttributeModifier modifier) {
        Attribute attribute = modifier.getAttribute();
        if (attribute instanceof GenericAttribute) {
            attributeCommandService.updateGenericAttribute(entityId, (GenericAttribute) attribute);
        }
    }
}
