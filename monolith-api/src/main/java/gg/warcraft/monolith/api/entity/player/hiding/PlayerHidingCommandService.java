package gg.warcraft.monolith.api.entity.player.hiding;

import java.util.UUID;

public interface PlayerHidingCommandService {

    void hidePlayer(UUID playerId);

    void revealPlayer(UUID playerId);
}
