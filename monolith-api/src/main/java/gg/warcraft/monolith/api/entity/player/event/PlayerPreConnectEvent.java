package gg.warcraft.monolith.api.entity.player.event;

/**
 * A PlayerPreConnectEvent is fired whenever a {@code Player} is trying to connect to the server.
 */
public interface PlayerPreConnectEvent extends PlayerEvent {

    /**
     * @return The Minecraft name of the player. Never null or empty.
     */
    String getName();
}
