package gg.warcraft.monolith.api.command;

import java.util.List;

/**
 * A command is an action that can be executed on the server. Both the name as well as all optional aliases can be used
 * to execute it.
 */
public interface Command {

    /**
     * Returns the name of this command.
     * <p>
     * This name is the primary command to execute this command.
     *
     * @return The name of this command. Never null or empty.
     */
    String getName();

    /**
     * Returns the set of aliases of this command, or an empty set.
     * <p>
     * All aliases can be used as secondary commands to execute this command.
     *
     * @return The set of aliases of this command. Never null, but can be empty. Items are never null or empty.
     */
    List<String> getAliases();

    /**
     * Returns the command handler of this command.
     *
     * @return The command handler of this command. Never null.
     */
    CommandHandler getHandler();
}
