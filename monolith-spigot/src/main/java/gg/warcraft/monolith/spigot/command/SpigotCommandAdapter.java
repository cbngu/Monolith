package gg.warcraft.monolith.spigot.command;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import gg.warcraft.monolith.api.command.Command;
import gg.warcraft.monolith.api.command.service.CommandServerAdapter;
import org.bukkit.Server;
import org.bukkit.command.CommandMap;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.UUID;

@Singleton
public class SpigotCommandAdapter implements CommandServerAdapter {
    private static final String NAME_ALREADY_EXISTS = "Failed to create command '%s', name already exists";
    private static final String ALIAS_ALREADY_EXISTS = "Failed to create command '%s', alias '%s' already exists";

    private final Server server;
    private final Plugin plugin;

    final CommandMap commandMap;
    final Constructor<PluginCommand> pluginCommandConstructor;

    @Inject
    public SpigotCommandAdapter(Server server, Plugin plugin) {
        this.server = server;
        this.plugin = plugin;

        try {
            final Field commandMapField = server.getClass().getDeclaredField("commandMap");
            commandMapField.setAccessible(true);
            this.commandMap = (CommandMap) commandMapField.get(server);
        } catch (Exception ex) {
            throw new IllegalStateException("Failed to initialize command map", ex.getCause());
        }

        try {
            pluginCommandConstructor = PluginCommand.class.getDeclaredConstructor(String.class, Plugin.class);
            pluginCommandConstructor.setAccessible(true);
        } catch (Exception ex) {
            throw new IllegalStateException("Failed to initialize plugin command constructor", ex.getCause());
        }
    }

    @Override
    public boolean isCommandAvailable(String command) {
        return server.getPluginCommand(command) == null;
    }

    @Override
    public void dispatchCommandFor(String command, UUID playerId) {
        Player player = server.getPlayer(playerId);
        player.performCommand(command);
    }

    @Override
    public void dispatchConsoleCommand(String command) {
        ConsoleCommandSender consoleSender = server.getConsoleSender();
        server.dispatchCommand(consoleSender, command);
    }

    @Override
    public void registerCommand(Command command) {
        String name = command.getName();
        PluginCommand pluginCommandByName = server.getPluginCommand(name);
        if (pluginCommandByName != null) {
            String nameAlreadyExists = String.format(NAME_ALREADY_EXISTS, name);
            throw new IllegalArgumentException(nameAlreadyExists);
        }

        command.getAliases().forEach(alias -> {
            PluginCommand pluginCommandByAlias = server.getPluginCommand(alias);
            if (pluginCommandByAlias != null) {
                String nameAlreadyExists = String.format(ALIAS_ALREADY_EXISTS, name, alias);
                throw new IllegalArgumentException(nameAlreadyExists);
            }
        });

        try {
            PluginCommand newPluginCommand = pluginCommandConstructor.newInstance(name, plugin);
            newPluginCommand.setAliases(command.getAliases());
            commandMap.register(name, newPluginCommand);
        } catch (Exception ex) {
            String pluginCommandException = String.format("Failed to instantiate plugin command with name '%s'", name);
            throw new IllegalStateException(pluginCommandException, ex.getCause());
        }
    }
}
