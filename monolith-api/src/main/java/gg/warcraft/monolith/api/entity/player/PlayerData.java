package gg.warcraft.monolith.api.entity.player;

import gg.warcraft.monolith.api.entity.EntityData;

import java.util.UUID;

/**
 * PlayerData represents the custom data associated with a {@code Player}.
 */
public interface PlayerData extends EntityData {

    /**
     * @return The id of the player this data belongs to. Never null.
     */
    UUID getPlayerId();

    /**
     * @return The Minecraft (account) name of this player. Never null or empty.
     */
    String getMinecraftName();

    /**
     * @return The current display name of this player. Never null or empty.
     */
    String getDisplayName();

    /**
     * @return The unix timestamp in milliseconds when this player connected this session, or the previous session if
     * they have since logged off.
     */
    long getTimeOfConnect();

    /**
     * @return The unix timestamp in milliseconds when this player first connected to the server.
     */
    long getTimeOfFirstConnect();

    /**
     * @return The unix timestamp in milliseconds when this player was last seen on the server.
     */
    long getTimeLastSeen();

    /**
     * @return The total amount of time in milliseconds this player has played on the server.
     */
    long getTimePlayed();
}
