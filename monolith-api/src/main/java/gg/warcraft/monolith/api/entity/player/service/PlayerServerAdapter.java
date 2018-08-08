package gg.warcraft.monolith.api.entity.player.service;

import gg.warcraft.monolith.api.entity.player.PlayerServerData;
import gg.warcraft.monolith.api.item.Item;

import java.util.Collection;
import java.util.UUID;

/**
 * This adapter is injectable, however you generally have no need for it. Use the command and query services instead.
 * <p>
 * The PlayerServerAdapter abstracts entity related server implementations from the Monolith domain. It can be used to
 * query the ids of all online players, whether a name is currently in use by a player, and which Minecraft id belongs
 * to a given name.
 */
public interface PlayerServerAdapter {

    /**
     * @param playerId The id of the player. Can not be null.
     * @return The server data of the player. Can be null.
     */
    PlayerServerData getPlayerServerData(UUID playerId);

    /**
     * @return The ids of all online players. Never null, but can be empty. Items are never null.
     */
    Collection<UUID> getOnlinePlayers();

    boolean giveItem(UUID playerId, Item item, boolean dropOnFullInventory);

    /**
     * @param minecraftName The Minecraft name. Can not be null.
     * @return The Minecraft id belonging to the name. Can be null.
     */
    UUID resolvePlayerId(String minecraftName);

    /**
     * @param playerId the id of the player. Can not be null.
     * @param message  The message to send. Can not be null or empty.
     */
    void sendMessage(UUID playerId, String message);
}
