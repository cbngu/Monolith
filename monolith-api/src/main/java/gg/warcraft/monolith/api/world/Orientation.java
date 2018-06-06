package gg.warcraft.monolith.api.world;

/**
 * An Orientation represents the pitch and yaw of an orientable actor, such as the head of a player.
 */
public interface Orientation {

    /**
     * Returns the pitch of this orientation.
     *
     * @return The pitch of this orientation.
     */
    float getPitch();

    /**
     * Returns the yaw of this orientation.
     *
     * @return The yaw of this orientation.
     */
    float getYaw();
}
