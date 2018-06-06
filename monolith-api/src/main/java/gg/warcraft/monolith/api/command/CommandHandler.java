package gg.warcraft.monolith.api.command;

import java.util.List;

/**
 * CommandHandler serves as the callback contract between the server and the handler when a command is executed.
 */
public interface CommandHandler {

    /**
     * Called by the server when a command this handler is registered to is executed.
     *
     * @param sender    The sender that executed the command.
     * @param command   The command that was executed.
     * @param label     The command name or optional alias that was used to execute the command.
     * @param arguments The arguments passed to the command.
     * @return True if the command was executed correctly, false otherwise.
     */
    boolean onCommand(CommandSender sender, Command command, String label, List<String> arguments);
}
