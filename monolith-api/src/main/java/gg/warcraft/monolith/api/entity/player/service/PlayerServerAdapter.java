package gg.warcraft.monolith.api.entity.player.service;

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
     * @return The ids of all online players. Never null, but can be empty. Items are never null.
     */
    Collection<UUID> getOnlinePlayers();

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
