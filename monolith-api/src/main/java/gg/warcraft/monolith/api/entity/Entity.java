package gg.warcraft.monolith.api.entity;

import gg.warcraft.monolith.api.entity.attribute.Attributes;
import gg.warcraft.monolith.api.entity.status.Status;
import gg.warcraft.monolith.api.world.OrientedLocation;
import org.joml.AABBf;
import org.joml.Vector3f;

import java.util.UUID;

/**
 * An Entity is a living actor on the server.
 */
public interface Entity {

    /**
     * @return The id of this entity. Never null.
     */
    UUID getId();

    /**
     * @return The type of this entity. Never null.
     */
    EntityType getType();

    /**
     * @return The location of this entity. Never null.
     */
    OrientedLocation getLocation();

    /**
     * @return The eye location of this entity. Never null.
     */
    OrientedLocation getEyeLocation();

    /**
     * @return The velocity of this entity. Never null.
     */
    Vector3f getVelocity();

    /**
     * @return The team of this entity. Can be null.
     */
    Team getTeam();

    /**
     * @return The attributes of this entity. Never null.
     */
    Attributes getAttributes();

    /**
     * @return The status of this entity. Never null.
     */
    Status getStatus();

    /**
     * @return The equipment this entity is currently wearing. Never null.
     */
    Equipment getEquipment();

    /**
     * @return The axis aligned bounding box of this entity. Never null.
     */
    AABBf getBoundingBox();

    /**
     * @param permission The permission. Can not be null or empty.
     * @return True if the entity has the permission favorably set, false otherwise.
     */
    boolean hasPermission(String permission);
}
