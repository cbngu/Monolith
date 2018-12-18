package gg.warcraft.monolith.app.command.service;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.command.Command;
import gg.warcraft.monolith.api.command.CommandHandler;
import gg.warcraft.monolith.api.command.service.CommandCommandService;
import gg.warcraft.monolith.api.command.service.CommandQueryService;
import gg.warcraft.monolith.api.command.service.CommandRepository;
import gg.warcraft.monolith.api.command.service.CommandServerAdapter;
import gg.warcraft.monolith.api.core.PluginLogger;
import gg.warcraft.monolith.app.command.SimpleCommand;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.logging.Logger;

public class DefaultCommandCommandService implements CommandCommandService {
    private static final String NAME_NULL_OR_EMPTY = "Failed to create command with null or empty name.";
    private static final String NAME_ALREADY_EXISTS = "Possible command conflict for '%s', name already exists";
    private static final String ALIAS_NULL_OR_EMPTY = "Failed to create command '%s' with null or empty alias.";
    private static final String ALIAS_ALREADY_EXISTS = "Possible command conflict for '%s', alias '%s' already exists";
    private static final String HANDLER_NULL = "Failed to create command '%s' with null handler";

    private final CommandQueryService queryService;
    private final CommandRepository repository;
    private final CommandServerAdapter adapter;
    private final Logger pluginLogger;

    @Inject
    public DefaultCommandCommandService(CommandQueryService queryService, CommandRepository repository,
                                        CommandServerAdapter adapter, @PluginLogger Logger pluginLogger) {
        this.queryService = queryService;
        this.repository = repository;
        this.adapter = adapter;
        this.pluginLogger = pluginLogger;
    }

    boolean validateName(String name, Predicate<String> isAvailable) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(NAME_NULL_OR_EMPTY);
        }
        if (!isAvailable.test(name)) {
            String nameAlreadyExists = String.format(NAME_ALREADY_EXISTS, name);
            pluginLogger.warning(nameAlreadyExists);
        }
        return true;
    }

    boolean validateAlias(String command, String alias, Predicate<String> isAvailable) {
        if (alias == null || alias.isEmpty()) {
            String aliasNullOrEmpty = String.format(ALIAS_NULL_OR_EMPTY, command);
            throw new IllegalArgumentException(aliasNullOrEmpty);
        }
        if (!isAvailable.test(alias)) {
            String aliasAlreadyExists = String.format(ALIAS_ALREADY_EXISTS, command, alias);
            pluginLogger.warning(aliasAlreadyExists);
        }
        return true;
    }

    boolean validateHandler(CommandHandler handler) {
        if (handler == null) {
            throw new IllegalArgumentException(HANDLER_NULL);
        }
        return true;
    }

    @Override
    public void createCommand(String name, List<String> aliases, CommandHandler handler) {
        Predicate<String> isAvailable = command ->
                queryService.getCommand(command) == null && adapter.isAliasAvailable(command);
        validateName(name, isAvailable);
        aliases.forEach(alias -> validateAlias(name, alias, isAvailable));
        validateHandler(handler);

        Command command = new SimpleCommand(name, aliases, handler);
        adapter.registerCommand(name, aliases);
        repository.save(command);
    }

    String formatCommand(String command, String... arguments) {
        StringJoiner joiner = new StringJoiner(" ");
        joiner.add(command);
        Arrays.stream(arguments).forEach(joiner::add);
        return joiner.toString();
    }

    @Override
    public void dispatchCommandFor(String command, UUID playerId, String... arguments) {
        String formattedCommand = formatCommand(command, arguments);
        adapter.dispatchCommandFor(formattedCommand, playerId);
    }

    @Override
    public void dispatchConsoleCommand(String command, String... arguments) {
        String formattedCommand = formatCommand(command, arguments);
        adapter.dispatchConsoleCommand(formattedCommand);
    }
}
