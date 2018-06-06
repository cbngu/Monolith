package gg.warcraft.monolith.app.command.handler;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import gg.warcraft.monolith.api.command.event.CommandExecutedEvent;
import gg.warcraft.monolith.api.command.service.CommandQueryService;

public class CommandExecutedHandler {
    private final CommandQueryService queryService;

    @Inject
    public CommandExecutedHandler(CommandQueryService queryService) {
        this.queryService = queryService;
    }

    @Subscribe
    public void onCommandExecuted(CommandExecutedEvent event) {
        var command = queryService.getCommand(event.getCommand());
        if (command != null) {
            command.getHandler().onCommand(event.getSender(), command, event.getLabel(), event.getArguments());
        }
    }
}
