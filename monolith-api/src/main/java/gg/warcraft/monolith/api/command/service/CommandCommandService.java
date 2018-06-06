package gg.warcraft.monolith.api.command.service;

import gg.warcraft.monolith.api.command.Command;
import gg.warcraft.monolith.api.command.CommandHandler;

import java.util.List;
import java.util.UUID;

/**
 * This service is injectable.
 * <p>
 * The CommandCommandService serves as a point of entry into the command module implementation. It allows for easy
 * registration of new commands at run time and offers convenience methods for executing a command as a given player or
 * the console.
 */
public interface CommandCommandService {

    /**
     * Creates a command with the specified name, optional aliases, and handler.
     *
     * @param command The command to register.
     * @param aliases The optional aliases.
     * @param handler The command handler.
     */
    void createCommand(String command, List<String> aliases, CommandHandler handler);

    /**
     * Dispatches the given command as the specified player.
     *
     * @param command   The command to execute.
     * @param playerId  The id of the player.
     * @param arguments The arguments of the command.
     */
    void dispatchCommandFor(Command command, UUID playerId, String... arguments);

    /**
     * Dispatches the given command as the console.
     *
     * @param command   The command to execute.
     * @param arguments The arguments of the command.
     */
    void dispatchConsoleCommand(Command command, String... arguments);
}
