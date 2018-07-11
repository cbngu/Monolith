package gg.warcraft.monolith.app.entity.player.service;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.entity.player.PlayerData;
import gg.warcraft.monolith.api.entity.player.service.PlayerCommandService;
import gg.warcraft.monolith.api.entity.player.service.PlayerDataRepository;
import gg.warcraft.monolith.api.entity.player.service.PlayerServerAdapter;
import gg.warcraft.monolith.api.util.ColorCode;
import gg.warcraft.monolith.app.entity.player.SimplePlayerData;

import java.util.UUID;

public class DefaultPlayerCommandService implements PlayerCommandService {
    private final PlayerDataRepository playerDataRepository;
    private final PlayerServerAdapter playerServerAdapter;

    @Inject
    public DefaultPlayerCommandService(PlayerDataRepository playerDataRepository,
                                       PlayerServerAdapter playerServerAdapter) {
        this.playerDataRepository = playerDataRepository;
        this.playerServerAdapter = playerServerAdapter;
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

    @Override
    public void sendMessage(UUID playerId, String message) {
        playerServerAdapter.sendMessage(playerId, message);
    }

    @Override
    public void sendNotification(UUID playerId, String notification) {
        sendMessage(playerId, ColorCode.YELLOW + "[SERVER] " + notification);
    }
}
