package gg.warcraft.monolith.api.world;

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
}
