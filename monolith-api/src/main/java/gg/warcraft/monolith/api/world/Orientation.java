package gg.warcraft.monolith.api.world;

import org.joml.Vector3f;

/**
 * An Orientation represents the pitch and yaw of an orientable actor, such as the head of a player.
 */
public interface Orientation {

    /**
     * @return The pitch of this orientation.
     */
    float getPitch();

    /**
     * @return The yaw of this orientation.
     */
    float getYaw();

    /**
     * @return The direction of this orientation as a unit vector. Never null.
     */
    Vector3f getDirection();
}
