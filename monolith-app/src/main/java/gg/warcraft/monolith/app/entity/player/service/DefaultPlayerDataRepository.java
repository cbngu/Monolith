package gg.warcraft.monolith.app.entity.player.service;

import com.google.inject.Singleton;
import gg.warcraft.monolith.api.entity.player.PlayerData;
import gg.warcraft.monolith.api.entity.player.service.PlayerDataRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Singleton
public class DefaultPlayerDataRepository implements PlayerDataRepository {
    private final Map<UUID, PlayerData> playerData;

    public DefaultPlayerDataRepository() {
        this.playerData = new HashMap<>();
    }

    @Override
    public PlayerData get(UUID playerId) {
        return playerData.get(playerId);
    }

    @Override
    public void save(PlayerData data) {
        playerData.put(data.getPlayerId(), data);
    }
}
