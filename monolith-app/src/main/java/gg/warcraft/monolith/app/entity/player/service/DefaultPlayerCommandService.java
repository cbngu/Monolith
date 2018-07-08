package gg.warcraft.monolith.app.entity.player.service;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.entity.player.PlayerData;
import gg.warcraft.monolith.api.entity.player.service.PlayerCommandService;
import gg.warcraft.monolith.api.entity.player.service.PlayerDataRepository;
import gg.warcraft.monolith.app.entity.player.SimplePlayerData;

import java.util.UUID;

public class DefaultPlayerCommandService implements PlayerCommandService {
    private final PlayerDataRepository playerDataRepository;

    @Inject
    public DefaultPlayerCommandService(PlayerDataRepository playerDataRepository) {
        this.playerDataRepository = playerDataRepository;
    }

    @Override
    public void updateTimePlayed(UUID playerId) {
        PlayerData playerData = playerDataRepository.get(playerId);
        long newTimeLastSeen = System.currentTimeMillis();
        long newTimePlayed = playerData.getTimePlayed() + (newTimeLastSeen - playerData.getTimeLastSeen());
        PlayerData newPlayerData = new SimplePlayerData(playerData.getPlayerId(), playerData.getMinecraftName(),
                playerData.getDisplayName(), playerData.getTimeOfConnect(), playerData.getTimeOfFirstConnect(),
                newTimeLastSeen, newTimePlayed, playerData.getTeam());
        playerDataRepository.save(newPlayerData);
    }
}
