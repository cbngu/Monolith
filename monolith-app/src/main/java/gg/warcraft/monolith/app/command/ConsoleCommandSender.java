package gg.warcraft.monolith.app.command;

import gg.warcraft.monolith.api.command.CommandSender;

import java.util.UUID;

public class ConsoleCommandSender implements CommandSender {
    private static final String NAME = "Console";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public UUID getPlayerId() {
        return null;
    }

    @Override
    public boolean isPlayer() {
        return false;
    }

    @Override
    public boolean isConsole() {
        return true;
    }
}
