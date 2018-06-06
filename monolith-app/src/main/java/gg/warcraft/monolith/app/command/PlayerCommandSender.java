package gg.warcraft.monolith.app.command;

import gg.warcraft.monolith.api.command.CommandSender;

import java.util.UUID;

public class PlayerCommandSender implements CommandSender {
    private final String name;
    private final UUID playerId;

    public PlayerCommandSender(String name, UUID playerId) {
        this.name = name;
        this.playerId = playerId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public UUID getPlayerId() {
        return playerId;
    }

    @Override
    public boolean isPlayer() {
        return true;
    }

    @Override
    public boolean isConsole() {
        return false;
    }
}
