package gg.warcraft.monolith.app.entity.attribute.service;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.entity.attribute.Attributes;
import gg.warcraft.monolith.api.entity.attribute.service.AttributeQueryService;
import gg.warcraft.monolith.api.entity.attribute.service.AttributeRepository;

import java.util.UUID;

public class DefaultAttributeQueryService implements AttributeQueryService {
    private final AttributeRepository repository;

    @Inject
    public DefaultAttributeQueryService(AttributeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Attributes getAttributes(UUID entityId) {
        return repository.getAttributes(entityId);
    }
}
