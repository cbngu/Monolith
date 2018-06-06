package gg.warcraft.monolith.api.command;

import java.util.UUID;

/**
 * CommandSender serves as a means of identifying what type of command sender, and if a player; who, you are dealing
 * with in {@code CommandHandler#onCommand}. Entity executed commands are currently not supported.
 */
public interface CommandSender {

    /**
     * Returns the name of this command sender.
     *
     * @return The name of this command sender. Never null or empty.
     */
    String getName();

    /**
     * Returns the id of the player this command sender represents or null if it represents the console.
     *
     * @return The id of this command sender. Can be null.
     */
    UUID getPlayerId();

    /**
     * Returns whether or not this command sender is a player.
     *
     * @return True if this command sender is a player, false otherwise.
     */
    boolean isPlayer();

    /**
     * Returns whether or not this command sender is the console.
     *
     * @return True if this command sender is the console, false otherwise.
     */
    boolean isConsole();
}
