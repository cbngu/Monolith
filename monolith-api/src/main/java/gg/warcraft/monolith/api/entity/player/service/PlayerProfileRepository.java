package gg.warcraft.monolith.api.entity.player.service;

import gg.warcraft.monolith.api.entity.player.PlayerProfile;

import java.util.UUID;

/**
 * This repository is injectable, however you generally have no need for it. Use the command and query services instead.
 * <p>
 * If you feel you absolutely have to use this repository it can be used to forgo the command service and save a {@code
 * PlayerProfile} to the Monolith domain directly. This repository does no safety checks whatsoever.
 */
public interface PlayerProfileRepository {

    /**
     * @param playerId The id of the player. Can not be null.
     * @return The profile of the player. Can be null.
     */
    PlayerProfile get(UUID playerId);

    /**
     * @param data The player profile to save. Can not be null.
     */
    void save(PlayerProfile profile);
}
