package gg.warcraft.monolith.app.entity.player.handler;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.entity.player.Player;
import gg.warcraft.monolith.api.entity.player.service.PlayerCommandService;
import gg.warcraft.monolith.api.entity.player.service.PlayerQueryService;

import java.util.Collections;
import java.util.Iterator;
import java.util.UUID;

public class PlayerProfileUpdateHandler implements Runnable {
    private final PlayerQueryService playerQueryService;
    private final PlayerCommandService playerCommandService;

    private Iterator<UUID> playerIds;

    @Inject
    public PlayerProfileUpdateHandler(PlayerQueryService playerQueryService,
                                      PlayerCommandService playerCommandService) {
        this.playerQueryService = playerQueryService;
        this.playerCommandService = playerCommandService;
        this.playerIds = Collections.emptyIterator();
    }

    @Override
    public void run() {
        if (!playerIds.hasNext()) {
            playerIds = playerQueryService.getOnlinePlayers().stream()
                    .map(Player::getId)
                    .iterator();
        }
        if (playerIds.hasNext()) {
            UUID playerId = playerIds.next();
            playerCommandService.update(playerId);
        }
    }
}
