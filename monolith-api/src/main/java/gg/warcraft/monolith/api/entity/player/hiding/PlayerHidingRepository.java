package gg.warcraft.monolith.api.entity.player.hiding;

import java.util.Set;
import java.util.UUID;

public interface PlayerHidingRepository {

    Set<UUID> getHiddenPlayers();

    Set<UUID> getHiddenFrom(UUID playerId);

    void save(UUID playerId, Set<UUID> hiddenFrom);

    void delete(UUID playerId);
}
