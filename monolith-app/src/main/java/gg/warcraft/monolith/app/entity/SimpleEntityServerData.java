package gg.warcraft.monolith.app.entity;

import gg.warcraft.monolith.api.entity.EntityServerData;
import gg.warcraft.monolith.api.entity.EntityType;
import gg.warcraft.monolith.api.world.OrientedLocation;
import org.joml.Vector3f;

import java.util.UUID;

public class SimpleEntityServerData implements EntityServerData {
    private final UUID entityId;
    private final EntityType type;
    private final OrientedLocation location;
    private final OrientedLocation eyeLocation;
    private final Vector3f velocity;

    public SimpleEntityServerData(UUID entityId, EntityType type, OrientedLocation location,
                                  OrientedLocation eyeLocation, Vector3f velocity) {
        this.entityId = entityId;
        this.type = type;
        this.location = location;
        this.eyeLocation = eyeLocation;
        this.velocity = velocity;
    }

    @Override
    public UUID getEntityId() {
        return entityId;
    }

    @Override
    public EntityType getType() {
        return type;
    }

    @Override
    public OrientedLocation getLocation() {
        return location;
    }

    @Override
    public OrientedLocation getEyeLocation() {
        return eyeLocation;
    }

    @Override
    public Vector3f getVelocity() {
        return velocity;
    }
}
