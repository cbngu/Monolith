package gg.warcraft.monolith.api.command;

import java.util.List;

/**
 * A Command is an action that can be executed on the server. Both its name as well as all of its optional aliases can
 * be used to execute it.
 */
public interface Command {

    /**
     * @return The name of this command. Never null or empty.
     */
    String getName();

    /**
     * @return The aliases of this command. Never null, but can be empty. Items are never null or empty.
     */
    List<String> getAliases();

    /**
     * @return The command handler of this command. Never null.
     */
    CommandHandler getHandler();
}
