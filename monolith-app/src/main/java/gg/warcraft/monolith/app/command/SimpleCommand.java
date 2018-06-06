package gg.warcraft.monolith.app.command;

import gg.warcraft.monolith.api.command.Command;
import gg.warcraft.monolith.api.command.CommandHandler;

import java.util.ArrayList;
import java.util.List;

public class SimpleCommand implements Command {
    private final String name;
    private final List<String> aliases;
    private final CommandHandler handler;

    public SimpleCommand(String name, List<String> aliases, CommandHandler handler) {
        this.name = name;
        this.aliases = aliases;
        this.handler = handler;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<String> getAliases() {
        return new ArrayList<>(aliases);
    }

    @Override
    public CommandHandler getHandler() {
        return handler;
    }
}
