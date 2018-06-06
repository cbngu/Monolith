package gg.warcraft.monolith.app.command.service;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.command.Command;
import gg.warcraft.monolith.api.command.CommandHandler;
import gg.warcraft.monolith.api.command.service.CommandCommandService;
import gg.warcraft.monolith.api.command.service.CommandQueryService;
import gg.warcraft.monolith.api.command.service.CommandRepository;
import gg.warcraft.monolith.api.command.service.CommandServerAdapter;
import gg.warcraft.monolith.app.command.SimpleCommand;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.UUID;

public class DefaultCommandCommandService implements CommandCommandService {
    private static final String NAME_NULL_OR_EMPTY = "Failed to create command with null or empty name.";
    private static final String NAME_ALREADY_EXISTS = "Failed to create command '%s', name already exists";
    private static final String ALIAS_NULL_OR_EMPTY = "Failed to create command '%s' with null or empty alias.";
    private static final String ALIAS_ALREADY_EXISTS = "Failed to create command '%s', alias '%s' already exists";
    private static final String HANDLER_NULL = "Failed to create command '%s' with null handler";

    private final CommandQueryService queryService;
    private final CommandRepository repository;
    private final CommandServerAdapter adapter;

    @Inject
    public DefaultCommandCommandService(CommandQueryService queryService, CommandRepository repository,
                                        CommandServerAdapter adapter) {
        this.queryService = queryService;
        this.repository = repository;
        this.adapter = adapter;
    }

    @Override
    public void createCommand(String name, List<String> aliases, CommandHandler handler) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(NAME_NULL_OR_EMPTY);
        }

        if (queryService.getCommand(name) != null || !adapter.isCommandAvailable(name)) {
            var nameAlreadyExists = String.format(NAME_ALREADY_EXISTS, name);
            throw new IllegalArgumentException(nameAlreadyExists);
        }

        aliases.forEach(alias -> {
            if (alias == null || alias.isEmpty()) {
                var aliasNullOrEmpty = String.format(ALIAS_NULL_OR_EMPTY, name);
                throw new IllegalArgumentException(aliasNullOrEmpty);
            }

            if (queryService.getCommand(alias) != null || !adapter.isCommandAvailable(alias)) {
                var aliasAlreadyExists = String.format(ALIAS_ALREADY_EXISTS, name, alias);
                throw new IllegalArgumentException(aliasAlreadyExists);
            }
        });

        if (handler == null) {
            throw new IllegalArgumentException(HANDLER_NULL);
        }

        var command = new SimpleCommand(name, aliases, handler);
        adapter.registerCommand(command);
        repository.save(command);
    }

    String formatCommand(Command command, String... arguments) {
        var joiner = new StringJoiner(" ");
        joiner.add(command.getName());
        Arrays.stream(arguments).forEach(joiner::add);
        return joiner.toString();
    }

    @Override
    public void dispatchCommandFor(Command command, UUID playerId, String... arguments) {
        var formattedCommand = formatCommand(command, arguments);
        adapter.dispatchCommandFor(formattedCommand, playerId);
    }

    @Override
    public void dispatchConsoleCommand(Command command, String... arguments) {
        var formattedCommand = formatCommand(command, arguments);
        adapter.dispatchConsoleCommand(formattedCommand);
    }
}
