package gg.warcraft.monolith.api.entity.player.service;

import gg.warcraft.monolith.api.entity.player.Player;

import java.util.List;
import java.util.UUID;

public interface PlayerQueryServiceDecorator extends PlayerQueryService {

    PlayerQueryService getPlayerQueryService();

    @Override
    default Player getPlayer(UUID playerId) {
        return getPlayerQueryService().getPlayer(playerId);
    }

    @Override
    default List<? extends Player> getOnlinePlayers() {
        return getPlayerQueryService().getOnlinePlayers();
    }

    @Override
    default UUID resolvePlayerId(String minecraftName) {
        return getPlayerQueryService().resolvePlayerId(minecraftName);
    }
}
