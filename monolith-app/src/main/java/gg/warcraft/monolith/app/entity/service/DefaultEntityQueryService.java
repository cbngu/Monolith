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
import org.joml.AABBf;
import org.joml.Intersectionf;
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
        Entity entity = getEntity(entityId);
        OrientedLocation origin = entity.getEyeLocation();
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

        AABBf boundingBox = new AABBf(origin.toVector(), target.toVector());
        boundingBox = boundingBox.correctBounds();

        float deltaX = (boundingBox.maxX - boundingBox.minX) * 0.5f;
        float deltaY = (boundingBox.maxY - boundingBox.minY) * 0.5f;
        float deltaZ = (boundingBox.maxZ - boundingBox.minZ) * 0.5f;

        float centerX = boundingBox.minX + deltaX;
        float centerY = boundingBox.minY + deltaY;
        float centerZ = boundingBox.minZ + deltaZ;

        Location center = worldQueryService.getLocation(origin.getWorld().getType(), centerX, centerY, centerZ);
        LineSegmentf intersectionLine = new LineSegmentf(origin.toVector(), target.toVector());
        List<Entity> nearbyEntities = getNearbyEntities(center, deltaX, deltaY, deltaZ);
        float closestIntersectionScalar = Float.MAX_VALUE;
        Entity closestIntersectedEntity = null;
        for (Entity nearbyEntity : nearbyEntities) {
            Vector2f intersection = new Vector2f();
            int result = nearbyEntity.getBoundingBox().intersectLineSegment(intersectionLine, intersection);
            if (result != Intersectionf.OUTSIDE) {
                if (intersection.x < closestIntersectionScalar) {
                    closestIntersectionScalar = intersection.x;
                    closestIntersectedEntity = nearbyEntity;
                }
            }
        }
        // NOTE to add the location of intersection with entity use p(t) = p0 + t * (p1 - p0) where t is the closestIntersectionScalar
        return new SimpleEntityTarget(closestIntersectedEntity, block);
    }
}
