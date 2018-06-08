package gg.warcraft.monolith.api.entity;

import gg.warcraft.monolith.api.world.OrientedLocation;
import org.joml.Vector3f;

import java.util.UUID;

public interface EntityServerData {

    /**
     * @return The id of the entity this data belongs to. Never null.
     */
    UUID getEntityId();

    /**
     * @return The type of the entity this data belongs to. Never null.
     */
    EntityType getType();

    /**
     * @return The location of the entity this data belongs to. Never null.
     */
    OrientedLocation getLocation();

    /**
     * @return The eye location of the entity this data belongs to. Never null.
     */
    OrientedLocation getEyeLocation();

    /**
     * @return The velocity of the entity this data belongs to. Never null.
     */
    Vector3f getVelocity();
}
