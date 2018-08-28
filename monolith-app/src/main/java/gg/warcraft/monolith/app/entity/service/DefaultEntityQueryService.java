package gg.warcraft.monolith.app.entity.service;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.entity.Entity;
import gg.warcraft.monolith.api.entity.EntityFactory;
import gg.warcraft.monolith.api.entity.EntityServerData;
import gg.warcraft.monolith.api.entity.attribute.service.AttributeQueryService;
import gg.warcraft.monolith.api.entity.service.EntityProfileRepository;
import gg.warcraft.monolith.api.entity.service.EntityQueryService;
import gg.warcraft.monolith.api.entity.service.EntityServerAdapter;
import gg.warcraft.monolith.api.entity.status.service.StatusQueryService;
import gg.warcraft.monolith.api.world.block.BlockIteratorFactory;
import gg.warcraft.monolith.api.world.block.BlockTypeUtils;
import gg.warcraft.monolith.api.world.location.Location;
import gg.warcraft.monolith.api.world.service.WorldQueryService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class DefaultEntityQueryService implements EntityQueryService {
    private final EntityProfileRepository entityProfileRepository;
    private final AttributeQueryService attributeQueryService;
    private final StatusQueryService statusQueryService;
    private final EntityServerAdapter entityServerAdapter;
    private final WorldQueryService worldQueryService;
    private final EntityFactory entityFactory;
    private final BlockIteratorFactory blockIteratorFactory;
    private final BlockTypeUtils blockTypeUtils;

    @Inject
    public DefaultEntityQueryService(EntityProfileRepository entityProfileRepository,
                                     AttributeQueryService attributeQueryService, StatusQueryService statusQueryService,
                                     EntityServerAdapter entityServerAdapter, WorldQueryService worldQueryService,
                                     EntityFactory entityFactory, BlockIteratorFactory blockIteratorFactory,
                                     BlockTypeUtils blockTypeUtils) {
        this.entityProfileRepository = entityProfileRepository;
        this.attributeQueryService = attributeQueryService;
        this.statusQueryService = statusQueryService;
        this.entityServerAdapter = entityServerAdapter;
        this.worldQueryService = worldQueryService;
        this.entityFactory = entityFactory;
        this.blockIteratorFactory = blockIteratorFactory;
        this.blockTypeUtils = blockTypeUtils;
    }

    Entity getEntity(EntityServerData serverData) {
        UUID entityId = serverData.getEntityId();
        return entityFactory.createEntity(
                () -> entityProfileRepository.get(entityId),
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
