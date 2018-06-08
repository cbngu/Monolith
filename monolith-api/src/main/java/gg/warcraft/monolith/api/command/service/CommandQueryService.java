package gg.warcraft.monolith.api.command.service;

import gg.warcraft.monolith.api.command.Command;

/**
 * This service is injectable.
 * <p>
 * The CommandQueryService serves as a point of entry into the command implementation. It provides methods to query the
 * Monolith domain for a {@code Command} by name or alias and to check whether an alias is already in use or not.
 */
public interface CommandQueryService {

    /**
     * @param alias The name or alias of the command. Can not be null or empty.
     * @return The command belonging to the alias. Can be null.
     */
    Command getCommand(String alias);

    /**
     * @param alias The alias. Can not be null or empty.
     * @return True if the alias is not currently in use by another command, false otherwise.
     */
    boolean isAliasAvailable(String alias);
}
