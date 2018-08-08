package gg.warcraft.monolith.app.entity.service;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.entity.Entity;
import gg.warcraft.monolith.api.entity.EntityServerData;
import gg.warcraft.monolith.api.entity.EntityTarget;
import gg.warcraft.monolith.api.entity.attribute.service.AttributeQueryService;
import gg.warcraft.monolith.api.entity.service.EntityProfileRepository;
import gg.warcraft.monolith.api.entity.service.EntityQueryService;
import gg.warcraft.monolith.api.entity.service.EntityServerAdapter;
import gg.warcraft.monolith.api.entity.status.service.StatusQueryService;
import gg.warcraft.monolith.api.world.Location;
import gg.warcraft.monolith.api.world.OrientedLocation;
import gg.warcraft.monolith.api.world.block.Block;
import gg.warcraft.monolith.api.world.block.BlockTypeUtils;
import gg.warcraft.monolith.api.world.service.WorldQueryService;
import gg.warcraft.monolith.app.entity.LazyEntity;
import gg.warcraft.monolith.app.entity.SimpleEntityTarget;
import org.joml.LineSegmentf;
import org.joml.Vector2f;
import org.joml.Vector3fc;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class DefaultEntityQueryService implements EntityQueryService {
    private final EntityProfileRepository entityProfileRepository;
    private final AttributeQueryService attributeQueryService;
    private final StatusQueryService statusQueryService;
    private final EntityServerAdapter entityServerAdapter;
    private final WorldQueryService worldQueryService;
    private final BlockTypeUtils blockTypeUtils;

    @Inject
    public DefaultEntityQueryService(EntityProfileRepository entityProfileRepository,
                                     AttributeQueryService attributeQueryService, StatusQueryService statusQueryService,
                                     EntityServerAdapter entityServerAdapter, WorldQueryService worldQueryService,
                                     BlockTypeUtils blockTypeUtils) {
        this.entityProfileRepository = entityProfileRepository;
        this.attributeQueryService = attributeQueryService;
        this.statusQueryService = statusQueryService;
        this.entityServerAdapter = entityServerAdapter;
        this.worldQueryService = worldQueryService;
        this.blockTypeUtils = blockTypeUtils;
    }

    Entity getEntity(EntityServerData serverData) {
        UUID entityId = serverData.getEntityId();
        return new LazyEntity(
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

    @Override
    public EntityTarget getTarget(UUID entityId, float range) { // TODO should this be in PlayerQueryService?
        Entity player = getEntity(entityId);
        OrientedLocation origin = player.getEyeLocation();
        Vector3fc direction = origin.getDirection();
        Location target = origin;
        Block block;
        do {
            target = target.add(direction);
            block = worldQueryService.getBlockAt(target);
            if (blockTypeUtils.getNonSolids().contains(block.getType())) {
                break;
            }
        } while (origin.toVector().distance(target.toVector()) <= range);

        float minX = Math.min(origin.getX(), target.getX());
        float maxX = Math.max(origin.getX(), target.getX());
        float minY = Math.min(origin.getY(), target.getY());
        float maxY = Math.max(origin.getY(), target.getY());
        float minZ = Math.min(origin.getZ(), target.getZ());
        float maxZ = Math.max(origin.getZ(), target.getZ());

        float deltaX = (maxX - minX) * 0.5f;
        float deltaY = (maxY - minY) * 0.5f;
        float deltaZ = (maxZ - minZ) * 0.5f;

        float centerX = minX + deltaX;
        float centerY = minY + deltaY;
        float centerZ = minZ + deltaZ;

        Location center = worldQueryService.getLocation(origin.getWorld().getType(), centerX, centerY, centerZ);
        LineSegmentf intersectionLine = new LineSegmentf(origin.getX(), origin.getY(), origin.getZ(),
                target.getX(), target.getY(), target.getZ());
        List<Entity> entities = getNearbyEntities(center, deltaX, deltaY, deltaZ);
        Entity closestIntersectedEntity;
        for (Entity entity : entities) {
            Vector2f result = new Vector2f();
            entity.getBoundingBox().intersectLineSegment(intersectionLine, result);
        }
        return new SimpleEntityTarget(null, null); // TODO add values
    }
}
