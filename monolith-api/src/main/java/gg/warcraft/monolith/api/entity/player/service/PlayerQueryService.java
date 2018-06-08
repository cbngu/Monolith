package gg.warcraft.monolith.api.entity.player.service;

import gg.warcraft.monolith.api.entity.player.Player;

import java.util.Collection;
import java.util.UUID;

/**
 * This service is injectable.
 * <p>
 * The PlayerQueryService serves as a point of entry into the entity implementation. It provides methods to query a
 * {@code Player} by id, but also the ids of all online players, whether a name is currently in use by a player, and
 * which Minecraft id belongs to a given name.
 */
public interface PlayerQueryService {

    /**
     * @param playerId The id of the player. Can not be null.
     * @return The player. Can be null.
     */
    Player getPlayer(UUID playerId);

    /**
     * @return The ids of all online players. Never null, but can be empty. Items are never null.
     */
    Collection<? extends Player> getOnlinePlayers();

    /**
     * @param name The name. Can not be null or empty.
     * @return True if the name is not currently used by a player, false otherwise.
     */
    boolean isNameAvailable(String name);

    /**
     * @param minecraftName The Minecraft name. Can not be null.
     * @return The Minecraft id belonging to the name. Can be null.
     */
    UUID resolvePlayerId(String minecraftName);
}
