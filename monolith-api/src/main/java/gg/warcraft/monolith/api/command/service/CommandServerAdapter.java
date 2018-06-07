package gg.warcraft.monolith.api.command.service;

import gg.warcraft.monolith.api.command.Command;

import java.util.UUID;

/**
 * This adapter is injectable, however you generally have no need for it. Use the command and query services instead.
 * <p>
 * The CommandServerAdapter abstracts command related server implementations from the Monolith domain. It can be used to
 * query the server, but also to directly inject commands into the command map of the server implementation.
 */
public interface CommandServerAdapter {

    /**
     * Checks whether the command is already used by a command on the server.
     *
     * @param command The command.
     * @return True if the command is not currently in use by a command on the server, false otherwise.
     */
    boolean isCommandAvailable(String command);

    /**
     * Dispatches the command as the specified player.
     *
     * @param command  The command to execute. This should include all of the arguments space separated.
     * @param playerId The id of the player.
     */
    void dispatchCommandFor(String command, UUID playerId);

    /**
     * Dispatches the command as the console.
     *
     * @param command The command to execute. This should include all of the arguments space separated.
     */
    void dispatchConsoleCommand(String command);

    /**
     * Registers the command with the server.
     *
     * @param command The command.
     */
    void registerCommand(Command command);
}
