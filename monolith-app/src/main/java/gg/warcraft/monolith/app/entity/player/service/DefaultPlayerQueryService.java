package gg.warcraft.monolith.app.entity.player.service;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.entity.attribute.service.AttributeQueryService;
import gg.warcraft.monolith.api.entity.player.Player;
import gg.warcraft.monolith.api.entity.player.service.PlayerDataRepository;
import gg.warcraft.monolith.api.entity.player.service.PlayerQueryService;
import gg.warcraft.monolith.api.entity.player.service.PlayerServerAdapter;
import gg.warcraft.monolith.api.entity.service.EntityServerAdapter;
import gg.warcraft.monolith.api.entity.status.service.StatusQueryService;
import gg.warcraft.monolith.app.entity.player.LazyPlayer;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

public class DefaultPlayerQueryService implements PlayerQueryService {
    private final PlayerDataRepository playerDataRepository;
    private final AttributeQueryService attributeQueryService;
    private final StatusQueryService statusQueryService;
    private final PlayerServerAdapter playerServerAdapter;
    private final EntityServerAdapter entityServerAdapter;

    @Inject
    public DefaultPlayerQueryService(PlayerDataRepository playerDataRepository,
                                     AttributeQueryService attributeQueryService, StatusQueryService statusQueryService,
                                     PlayerServerAdapter playerServerAdapter, EntityServerAdapter entityServerAdapter) {
        this.playerDataRepository = playerDataRepository;
        this.attributeQueryService = attributeQueryService;
        this.statusQueryService = statusQueryService;
        this.playerServerAdapter = playerServerAdapter;
        this.entityServerAdapter = entityServerAdapter;
    }

    @Override
    public Player getPlayer(UUID playerId) {
        return new LazyPlayer(
                () -> playerDataRepository.get(playerId),
                () -> entityServerAdapter.getEntityServerData(playerId),
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
    public boolean isNameAvailable(String name) {
        return false; // TODO: implement
    }

    @Override
    public UUID resolvePlayerId(String minecraftName) {
        return playerServerAdapter.resolvePlayerId(minecraftName);
    }
}
