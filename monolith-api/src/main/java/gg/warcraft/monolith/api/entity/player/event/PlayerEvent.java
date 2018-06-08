package gg.warcraft.monolith.api.entity.player.event;

import gg.warcraft.monolith.api.core.Event;

import java.util.UUID;

/**
 * PlayerEvent is a utility interface to group all player related events together.
 */
public interface PlayerEvent extends Event {

    /**
     * @return The id of the player.
     */
    UUID getPlayerId();
}
