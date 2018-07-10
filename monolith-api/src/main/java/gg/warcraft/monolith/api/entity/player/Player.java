package gg.warcraft.monolith.api.entity.player;

import gg.warcraft.monolith.api.entity.Entity;
import gg.warcraft.monolith.api.item.Item;

import java.util.List;

/**
 * A Player is a human actor on the server.
 */
public interface Player extends Entity {

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
     * @return The total amount of time in milliseconds this player has played on the server.
     */
    long getTimePlayed();

    /**
     * @return All items in the inventory of this player. Never null, but can be empty. Items are never null.
     */
    List<Item> getInventory();
}
