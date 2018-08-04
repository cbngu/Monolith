package gg.warcraft.monolith.api.entity.player.hiding;

import java.util.Set;
import java.util.UUID;

public interface PlayerHidingQueryService {

    Set<UUID> getHiddenPlayers();

    Set<UUID> getHiddenFrom(UUID playerId);
}
