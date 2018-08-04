package gg.warcraft.monolith.app.entity.player.hiding;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.entity.player.Player;
import gg.warcraft.monolith.api.entity.player.hiding.PlayerHidingCommandService;
import gg.warcraft.monolith.api.entity.player.hiding.PlayerHidingRepository;
import gg.warcraft.monolith.api.entity.player.hiding.PlayerHidingServerAdapter;
import gg.warcraft.monolith.api.entity.player.service.PlayerQueryService;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class DefaultPlayerHidingCommandService implements PlayerHidingCommandService {
    private final PlayerHidingRepository playerHidingRepository;
    private final PlayerHidingServerAdapter playerHidingServerAdapter;
    private final PlayerQueryService playerQueryService;

    @Inject
    public DefaultPlayerHidingCommandService(PlayerHidingRepository playerHidingRepository,
                                             PlayerHidingServerAdapter playerHidingServerAdapter,
                                             PlayerQueryService playerQueryService) {
        this.playerHidingRepository = playerHidingRepository;
        this.playerHidingServerAdapter = playerHidingServerAdapter;
        this.playerQueryService = playerQueryService;
    }

    @Override
    public void hidePlayer(UUID playerId) {
        Set<UUID> hideFrom = playerQueryService.getOnlinePlayers().stream()
                .map(Player::getId)
                .collect(Collectors.toSet());
        playerHidingRepository.save(playerId, hideFrom);
        playerHidingServerAdapter.hidePlayer(playerId, hideFrom.toArray(new UUID[0]));
    }

    @Override
    public void revealPlayer(UUID playerId) {
        Set<UUID> hiddenFrom = playerHidingRepository.getHiddenFrom(playerId);
        playerHidingServerAdapter.revealPlayer(playerId, hiddenFrom.toArray(new UUID[0]));
        playerHidingRepository.delete(playerId);
    }
}
