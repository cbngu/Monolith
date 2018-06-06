package gg.warcraft.monolith.api.command.service;

import gg.warcraft.monolith.api.command.Command;

/**
 * This repository is injectable, however you generally have no need for it. Use the command and query services instead.
 * <p>
 * If you feel you absolutely have to use this repository it can be used to forgo the command service and save commands
 * to the Monolith domain directly. This repository does no safety checks whatsoever.
 */
public interface CommandRepository {

    /**
     * Returns the command that belongs to the alias.
     *
     * @param alias The alias.
     * @return The command that belongs to the alias or null of none was found.
     */
    Command getCommand(String alias);

    /**
     * Saves the command to this repository while silently ignore null or empty names and aliases.
     *
     * @param command The command.
     */
    void save(Command command);
}
