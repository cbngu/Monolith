package gg.warcraft.monolith.spigot.entity.player;

import gg.warcraft.monolith.api.entity.player.GameMode;

public class SpigotGameModeMapper {

    org.bukkit.GameMode map(GameMode mode) {
        switch (mode) {
            case CREATIVE:
                return org.bukkit.GameMode.CREATIVE;
            case SURVIVAL:
                return org.bukkit.GameMode.SURVIVAL;
            case ADVENTURE:
                return org.bukkit.GameMode.ADVENTURE;
            case SPECTATOR:
                return org.bukkit.GameMode.SPECTATOR;
            default:
                return null;
        }
    }

    GameMode map(org.bukkit.GameMode mode) {
        switch (mode) {
            case CREATIVE:
                return GameMode.CREATIVE;
            case SURVIVAL:
                return GameMode.SURVIVAL;
            case ADVENTURE:
                return GameMode.ADVENTURE;
            case SPECTATOR:
                return GameMode.SPECTATOR;
            default:
                return null;
        }
    }
}
