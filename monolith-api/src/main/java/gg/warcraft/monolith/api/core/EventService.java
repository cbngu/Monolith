package gg.warcraft.monolith.api.core;

/**
 * This service is injectable.
 * <p>
 * The EventService allows you to easily subscribe to, publish, and unsubscribe from, events. It works in a similar
 * fashion to Spigot's {@code EventHandler} where you annotate the single parameter method you want to subscribe with
 * {@code com.google.common.eventbus.Subscribe} instead. The class of the method does not need to implement any
 * interface.
 */
public interface EventService {

    /**
     * Publishes the event to subscribed listeners.
     *
     * @param event The event.
     */
    void publish(Event event);

    /**
     * Subscribes the listener.
     *
     * @param listener The listener.
     */
    void subscribe(Object listener);

    /**
     * Unsubscribes the listener.
     *
     * @param listener The listener.
     */
    void unsubscribe(Object listener);
}
