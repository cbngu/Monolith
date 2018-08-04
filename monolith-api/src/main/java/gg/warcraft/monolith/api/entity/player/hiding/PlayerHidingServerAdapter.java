package gg.warcraft.monolith.api.entity.player.hiding;

import java.util.UUID;

public interface PlayerHidingServerAdapter {

    void hidePlayer(UUID playerId, UUID... from);

    void revealPlayer(UUID playerId, UUID... to);
}
