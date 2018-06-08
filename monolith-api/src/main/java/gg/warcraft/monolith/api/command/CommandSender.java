package gg.warcraft.monolith.api.command;

import java.util.UUID;

/**
 * CommandSender serves as a means of identifying what type of command sender, and if a {@code Player}; who, you are
 * dealing with in {@code CommandHandler#onCommand}.
 * <p>
 * Entity executed commands are currently not supported.
 */
public interface CommandSender {

    /**
     * @return The name of this command sender. Never null or empty.
     */
    String getName();

    /**
     * @return The player id of this command sender or null if it is the console.
     */
    UUID getPlayerId();

    /**
     * @return True if this command sender is a player, false otherwise.
     */
    boolean isPlayer();

    /**
     * @return True if this command sender is the console, false otherwise.
     */
    boolean isConsole();
}
