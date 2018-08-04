package gg.warcraft.monolith.app.entity.player.hiding;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.entity.player.hiding.PlayerHidingQueryService;
import gg.warcraft.monolith.api.entity.player.hiding.PlayerHidingRepository;

import java.util.Set;
import java.util.UUID;

public class DefaultPlayerHidingQueryService implements PlayerHidingQueryService {
    private final PlayerHidingRepository playerHidingRepository;

    @Inject
    public DefaultPlayerHidingQueryService(PlayerHidingRepository playerHidingRepository) {
        this.playerHidingRepository = playerHidingRepository;
    }

    @Override
    public Set<UUID> getHiddenPlayers() {
        return playerHidingRepository.getHiddenPlayers();
    }

    @Override
    public Set<UUID> getHiddenFrom(UUID playerId) {
        return playerHidingRepository.getHiddenFrom(playerId);
    }
}
