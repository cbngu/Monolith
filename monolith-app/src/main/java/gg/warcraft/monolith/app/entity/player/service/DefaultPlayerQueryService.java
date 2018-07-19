package gg.warcraft.monolith.app.entity.player.service;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.entity.attribute.service.AttributeQueryService;
import gg.warcraft.monolith.api.entity.player.Player;
import gg.warcraft.monolith.api.entity.player.service.PlayerProfileRepository;
import gg.warcraft.monolith.api.entity.player.service.PlayerQueryService;
import gg.warcraft.monolith.api.entity.player.service.PlayerServerAdapter;
import gg.warcraft.monolith.api.entity.status.service.StatusQueryService;
import gg.warcraft.monolith.app.entity.player.LazyPlayer;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

public class DefaultPlayerQueryService implements PlayerQueryService {
    private final PlayerProfileRepository playerProfileRepository;
    private final AttributeQueryService attributeQueryService;
    private final StatusQueryService statusQueryService;
    private final PlayerServerAdapter playerServerAdapter;

    @Inject
    public DefaultPlayerQueryService(PlayerProfileRepository playerProfileRepository,
                                     AttributeQueryService attributeQueryService, StatusQueryService statusQueryService,
                                     PlayerServerAdapter playerServerAdapter) {
        this.playerProfileRepository = playerProfileRepository;
        this.attributeQueryService = attributeQueryService;
        this.statusQueryService = statusQueryService;
        this.playerServerAdapter = playerServerAdapter;
    }

    @Override
    public Player getPlayer(UUID playerId) {
        return new LazyPlayer(
                () -> playerProfileRepository.get(playerId),
                () -> playerServerAdapter.getPlayerServerData(playerId),
                () -> attributeQueryService.getAttributes(playerId),
                () -> statusQueryService.getStatus(playerId));
    }

    @Override
    public Collection<? extends Player> getOnlinePlayers() {
        return playerServerAdapter.getOnlinePlayers().stream()
                .map(this::getPlayer)
                .collect(Collectors.toList());
    }

    @Override
    public UUID resolvePlayerId(String minecraftName) {
        return playerServerAdapter.resolvePlayerId(minecraftName);
    }
}
