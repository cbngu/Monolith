package gg.warcraft.monolith.app.command.service;

import com.google.inject.Singleton;
import gg.warcraft.monolith.api.command.Command;
import gg.warcraft.monolith.api.command.service.CommandRepository;

import java.util.HashMap;
import java.util.Map;

@Singleton
public class DefaultCommandRepository implements CommandRepository {
    final Map<String, Command> commands;

    public DefaultCommandRepository() {
        this.commands = new HashMap<>();
    }

    @Override
    public Command getCommand(String alias) {
        return commands.get(alias);
    }

    @Override
    public void save(Command command) {
        String name = command.getName();
        if (name != null && !name.isEmpty()) {
            commands.put(name, command);
        }

        command.getAliases().forEach(alias -> {
            if (alias != null && !alias.isEmpty()) {
                commands.put(alias, command);
            }
        });
    }
}
