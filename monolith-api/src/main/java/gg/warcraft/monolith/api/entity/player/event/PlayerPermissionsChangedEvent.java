package gg.warcraft.monolith.api.entity.player.event;

import java.util.Map;

/**
 * A PlayerPermissionsChangedEvent is fired whenever the permissions of a {@code Player} have changed.
 */
public interface PlayerPermissionsChangedEvent extends PlayerEvent {

    Map<String, Boolean> getPermissions();
}
