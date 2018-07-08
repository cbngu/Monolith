package gg.warcraft.monolith.app.entity.service;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.entity.Entity;
import gg.warcraft.monolith.api.entity.EntityServerData;
import gg.warcraft.monolith.api.entity.attribute.service.AttributeQueryService;
import gg.warcraft.monolith.api.entity.service.EntityDataRepository;
import gg.warcraft.monolith.api.entity.service.EntityQueryService;
import gg.warcraft.monolith.api.entity.service.EntityServerAdapter;
import gg.warcraft.monolith.api.entity.status.service.StatusQueryService;
import gg.warcraft.monolith.api.world.Location;
import gg.warcraft.monolith.app.entity.LazyEntity;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class DefaultEntityQueryService implements EntityQueryService {
    private final EntityDataRepository entityDataRepository;
    private final AttributeQueryService attributeQueryService;
    private final StatusQueryService statusQueryService;
    private final EntityServerAdapter entityServerAdapter;

    @Inject
    public DefaultEntityQueryService(EntityDataRepository entityDataRepository,
                                     AttributeQueryService attributeQueryService,
                                     StatusQueryService statusQueryService,
                                     EntityServerAdapter entityServerAdapter) {
        this.entityDataRepository = entityDataRepository;
        this.attributeQueryService = attributeQueryService;
        this.statusQueryService = statusQueryService;
        this.entityServerAdapter = entityServerAdapter;
    }

    Entity getEntity(EntityServerData serverData) {
        UUID entityId = serverData.getEntityId();
        return new LazyEntity(
                () -> entityDataRepository.get(entityId),
                () -> serverData,
                () -> attributeQueryService.getAttributes(entityId),
                () -> statusQueryService.getStatus(entityId));
    }

    @Override
    public Entity getEntity(UUID entityId) {
        EntityServerData serverData = entityServerAdapter.getEntityServerData(entityId);
        if (serverData != null) {
            return getEntity(serverData);
        }
        return null;
    }

    @Override
    public List<Entity> getNearbyEntities(Location location, float radius) {
        return getNearbyEntities(location, radius, radius, radius);
    }

    @Override
    public List<Entity> getNearbyEntities(Location location, float deltaX, float deltaY, float deltaZ) {
        return entityServerAdapter.getNearbyEntitiesServerData(location, deltaX, deltaY, deltaZ).stream()
                .map(this::getEntity)
                .collect(Collectors.toList());
    }
}
