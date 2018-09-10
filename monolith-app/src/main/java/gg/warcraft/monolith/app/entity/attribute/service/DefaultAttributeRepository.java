package gg.warcraft.monolith.app.entity.attribute.service;

import com.google.inject.Singleton;
import gg.warcraft.monolith.api.entity.attribute.Attributes;
import gg.warcraft.monolith.api.entity.attribute.service.AttributeRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Singleton
public class DefaultAttributeRepository implements AttributeRepository {
    final Map<UUID, Attributes> attributes;

    public DefaultAttributeRepository() {
        this.attributes = new HashMap<>();
    }

    @Override
    public Attributes getAttributes(UUID entityId) {
        return attributes.get(entityId);
    }

    @Override
    public void save(Attributes attributes) {
        this.attributes.put(attributes.getEntityId(), attributes);
    }

    @Override
    public void delete(UUID entityId) {
        attributes.remove(entityId);
    }
}
