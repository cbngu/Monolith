package gg.warcraft.monolith.api.command.service;

import gg.warcraft.monolith.api.command.Command;

/**
 * This service is injectable.
 * <p>
 * The CommandQueryService serves as a point of entry into the command implementation and allows you to query commands
 * by name or alias.
 */
public interface CommandQueryService {

    /**
     * Returns the command that belongs to the alias.
     *
     * @param alias The alias.
     * @return The command that belongs to the alias or null of none was found.
     */
    Command getCommand(String alias);
}
