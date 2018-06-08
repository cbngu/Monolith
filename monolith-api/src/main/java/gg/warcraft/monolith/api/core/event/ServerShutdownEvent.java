package gg.warcraft.monolith.api.core.event;

import gg.warcraft.monolith.api.core.Event;

/**
 * ServerShutdownEvent is a quality of life event that allows subscribers to perform shutdown tasks without having to be
 * notified from the plugin's disable method.
 * <p>
 * This event is fired synchronously and the server WILL shut down this tick.
 */
public interface ServerShutdownEvent extends Event {

}
