package gg.warcraft.monolith.app.entity.attribute;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import gg.warcraft.monolith.api.entity.attribute.Attribute;
import gg.warcraft.monolith.api.entity.attribute.AttributeModifier;
import gg.warcraft.monolith.api.entity.attribute.Attributes;
import gg.warcraft.monolith.api.entity.attribute.GenericAttribute;
import gg.warcraft.monolith.api.entity.attribute.service.AttributeCommandService;
import gg.warcraft.monolith.api.entity.service.EntityServerAdapter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class LazyAttributes implements Attributes {
    private final AttributeCommandService attributeCommandService;
    private final EntityServerAdapter entityServerAdapter;
    private final UUID entityId;
    private final Map<Attribute, Set<AttributeModifier>> modifiers;
    private final Map<Attribute, Float> attributes;

    @Inject
    public LazyAttributes(AttributeCommandService attributeCommandService, EntityServerAdapter entityServerAdapter,
                          @Assisted UUID entityId, @Assisted Map<Attribute, Set<AttributeModifier>> modifiers) {
        this.attributeCommandService = attributeCommandService;
        this.entityServerAdapter = entityServerAdapter;
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
        if (attribute instanceof GenericAttribute) {
            return entityServerAdapter.getGenericAttribute(entityId, (GenericAttribute) attribute);
        } else {
            return attributes.computeIfAbsent(attribute, key -> getModifiers(attribute).stream()
                    .map(AttributeModifier::getValue)
                    .reduce(Float::sum)
                    .orElse(0f));
        }
    }

    @Override
    public void onChange(AttributeModifier modifier) {
        Attribute attribute = modifier.getAttribute();
        if (attribute instanceof GenericAttribute) {
            attributeCommandService.updateGenericAttribute(entityId, (GenericAttribute) attribute);
        }
    }
}
