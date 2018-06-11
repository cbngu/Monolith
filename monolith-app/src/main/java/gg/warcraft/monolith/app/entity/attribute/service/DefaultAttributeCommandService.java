package gg.warcraft.monolith.app.entity.attribute.service;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.entity.attribute.Attribute;
import gg.warcraft.monolith.api.entity.attribute.AttributeModifier;
import gg.warcraft.monolith.api.entity.attribute.Attributes;
import gg.warcraft.monolith.api.entity.attribute.service.AttributeCommandService;
import gg.warcraft.monolith.api.entity.attribute.service.AttributeRepository;
import gg.warcraft.monolith.app.entity.attribute.SimpleAttributes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class DefaultAttributeCommandService implements AttributeCommandService {
    private final AttributeRepository repository;

    @Inject
    public DefaultAttributeCommandService(AttributeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addAttributeModifier(AttributeModifier modifier, UUID entityId) {
        Attributes attributes = repository.getAttributes(entityId);
        Set<AttributeModifier> attributeModifiers = attributes.getModifiers(modifier.getAttribute());
        if (!attributeModifiers.contains(modifier)) {
            Set<AttributeModifier> newAttributeModifiers = new HashSet<>(attributeModifiers);
            newAttributeModifiers.add(modifier);
            HashMap<Attribute, Set<AttributeModifier>> newModifiers = new HashMap<>(attributes.getModifiers());
            newModifiers.put(modifier.getAttribute(), newAttributeModifiers);
            Attributes newAttributes = new SimpleAttributes(entityId, newModifiers);
            repository.save(newAttributes);
        }
    }

    @Override
    public void removeAttributeModifier(AttributeModifier modifier, UUID entityId) {
        Attributes attributes = repository.getAttributes(entityId);
        Set<AttributeModifier> attributeModifiers = attributes.getModifiers(modifier.getAttribute());
        if (attributeModifiers.contains(modifier)) {
            Set<AttributeModifier> newAttributeModifiers = new HashSet<>(attributeModifiers);
            newAttributeModifiers.remove(modifier);
            HashMap<Attribute, Set<AttributeModifier>> newModifiers = new HashMap<>(attributes.getModifiers());
            newModifiers.put(modifier.getAttribute(), newAttributeModifiers);
            Attributes newAttributes = new SimpleAttributes(entityId, newModifiers);
            repository.save(newAttributes);
        }
    }
}
