package gg.warcraft.monolith.api.command;

import java.util.List;

/**
 * A CommandHandler is invoked whenever its {@code Command} is executed.
 */
public interface CommandHandler {

    /**
     * @param sender    The sender that executed the command. Never null.
     * @param command   The command that was executed. Never null.
     * @param label     The command name or alias that was used to execute the command. Never null or empty.
     * @param arguments The command arguments. Never null, but can be empty. Items are never null or empty.
     * @return True if the command was executed correctly, false otherwise.
     */
    boolean onCommand(CommandSender sender, Command command, String label, List<String> arguments);
}
