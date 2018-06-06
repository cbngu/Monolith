package gg.warcraft.monolith.app.command.event;

import gg.warcraft.monolith.api.command.CommandSender;
import gg.warcraft.monolith.api.command.event.CommandExecutedEvent;

import java.util.List;

public class SimpleCommandExecutedEvent implements CommandExecutedEvent {
    private final CommandSender sender;
    private final String command;
    private final String label;
    private final List<String> arguments;

    public SimpleCommandExecutedEvent(CommandSender sender, String command, String label, List<String> arguments) {
        this.sender = sender;
        this.command = command;
        this.label = label;
        this.arguments = arguments;
    }

    @Override
    public CommandSender getSender() {
        return sender;
    }

    @Override
    public String getCommand() {
        return command;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public List<String> getArguments() {
        return arguments;
    }
}
