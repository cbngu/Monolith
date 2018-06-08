package gg.warcraft.monolith.api.entity.player.service;

import java.util.UUID;

/**
 * This service is injectable.
 * <p>
 * The PlayerCommandService serves as a point of entry into the entity module implementation. It provides a method to
 * trigger an update of the total play time of a {@code Player}.
 */
public interface PlayerCommandService {

    /**
     * @param playerId The id of the player to update. Can not be null.
     */
    void updateTimePlayed(UUID playerId);
}
