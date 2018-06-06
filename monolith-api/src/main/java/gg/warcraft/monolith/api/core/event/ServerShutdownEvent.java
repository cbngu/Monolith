package gg.warcraft.monolith.api.core.event;

import gg.warcraft.monolith.api.core.Event;

/**
 * ServerShutdownEvent is a convenience event that allows subscribers to perform shutdown tasks without having to be
 * notified from the plugin's {@code onDisable} method. This event is fired synchronously and the server WILL shut down
 * this tick.
 */
public interface ServerShutdownEvent extends Event {

}
