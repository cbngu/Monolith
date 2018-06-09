package gg.warcraft.monolith.app.command.service;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.command.Command;
import gg.warcraft.monolith.api.command.service.CommandQueryService;
import gg.warcraft.monolith.api.command.service.CommandRepository;

public class DefaultCommandQueryService implements CommandQueryService {
    private final CommandRepository repository;

    @Inject
    public DefaultCommandQueryService(CommandRepository repository) {
        this.repository = repository;
    }

    @Override
    public Command getCommand(String alias) {
        return repository.getCommand(alias);
    }

    @Override
    public boolean isAliasAvailable(String alias) {
        return repository.getCommand(alias) == null;
    }
}
