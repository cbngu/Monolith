package gg.warcraft.monolith.api.command.service;

import gg.warcraft.monolith.api.command.Command;

/**
 * This repository is injectable, however you generally have no need for it. Use the command and query services instead.
 * <p>
 * If you feel you absolutely have to use this repository it can be used to forgo the command service and save a {@code
 * Command} to the Monolith domain directly. This repository does no safety checks whatsoever.
 */
public interface CommandRepository {

    /**
     * @param alias The name or alias of the command. Can not be null or empty.
     * @return The command belonging to the alias. Can be null.
     */
    Command getCommand(String alias);

    /**
     * Saves the {@code Command} to this repository while silently ignoring null or empty names and aliases.
     *
     * @param command The command to save. Can not be null.
     */
    void save(Command command);
}
