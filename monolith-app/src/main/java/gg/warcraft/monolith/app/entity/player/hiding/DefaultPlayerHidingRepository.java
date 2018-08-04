package gg.warcraft.monolith.app.entity.player.hiding;

import com.google.inject.Singleton;
import gg.warcraft.monolith.api.entity.player.hiding.PlayerHidingRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Singleton
public class DefaultPlayerHidingRepository implements PlayerHidingRepository {
    private final Map<UUID, Set<UUID>> playerHiddenFromIds;

    public DefaultPlayerHidingRepository() {
        this.playerHiddenFromIds = new HashMap<>();
    }

    @Override
    public Set<UUID> getHiddenPlayers() {
        return playerHiddenFromIds.keySet();
    }

    @Override
    public Set<UUID> getHiddenFrom(UUID playerId) {
        Set<UUID> hiddenFrom = playerHiddenFromIds.get(playerId);
        if (hiddenFrom == null) {
            return new HashSet<>();
        }
        return new HashSet<>(hiddenFrom);
    }

    @Override
    public void save(UUID playerId, Set<UUID> hiddenFrom) {
        if (hiddenFrom.isEmpty()) {
            delete(playerId);
        } else {
            playerHiddenFromIds.put(playerId, hiddenFrom);
        }
    }

    @Override
    public void delete(UUID playerId) {
        playerHiddenFromIds.remove(playerId);
    }
}
