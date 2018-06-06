package gg.warcraft.monolith.api.command.event;

import gg.warcraft.monolith.api.command.CommandSender;
import gg.warcraft.monolith.api.core.Event;

import java.util.List;

/**
 * A CommandExecutedEvent will be fired whenever a command has been executed by either a player or the console. Entity
 * executed commands are currently not supported.
 */
public interface CommandExecutedEvent extends Event {

    /**
     * Returns the sender of the command.
     *
     * @return The sender of the command. Never null.
     */
    CommandSender getSender();

    /**
     * Returns the executed command.
     *
     * @return The executed command. Never null.
     */
    String getCommand();

    /**
     * Returns the label used to execute the command.
     *
     * @return The label used to execute the command. Never null or empty.
     */
    String getLabel();

    /**
     * Returns the arguments used to execute the command.
     *
     * @return The arguments used to execute the command. Never null, but can be empty. Items are never null or empty.
     */
    List<String> getArguments();
}
