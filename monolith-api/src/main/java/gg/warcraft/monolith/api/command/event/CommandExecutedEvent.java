package gg.warcraft.monolith.api.command.event;

import gg.warcraft.monolith.api.command.CommandSender;
import gg.warcraft.monolith.api.core.Event;

import java.util.List;

/**
 * A CommandExecutedEvent will be fired whenever a {@code Command} created via the {@code CommandCommandService} has
 * been executed by either a player or the console.
 * <p>
 * Entity executed commands are currently not supported.
 */
public interface CommandExecutedEvent extends Event {

    /**
     * @return The sender of the command. Never null.
     */
    CommandSender getSender();

    /**
     * @return The executed command. Never null.
     */
    String getCommand();

    /**
     * @return The label used to execute the command. Never null or empty.
     */
    String getLabel();

    /**
     * @return The arguments used to execute the command. Never null, but can be empty. Items are never null or empty.
     */
    List<String> getArguments();
}
