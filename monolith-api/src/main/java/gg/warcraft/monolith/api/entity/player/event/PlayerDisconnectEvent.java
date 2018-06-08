package gg.warcraft.monolith.api.entity.player.event;

/**
 * A PlayerDisconnectEvent is fired whenever a {@code Player} has disconnected from the server. This event should only
 * be used in cases where you are solely interested in the fact whether a player has left the server. The quit or kick
 * messages can not be set as we can not be sure which caused this event to fire, nor can this event be cancelled as it
 * can represent a non-cancellable PlayerQuitEvent.
 */
public interface PlayerDisconnectEvent extends PlayerEvent {

}
