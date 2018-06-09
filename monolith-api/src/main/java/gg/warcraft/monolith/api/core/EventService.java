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
     * @param event The event to publish. Can not be null.
     */
    void publish(Event event);

    /**
     * @param listener The listener to subscribe. Can not be null.
     */
    void subscribe(Object listener);

    /**
     * @param listener The listener to unsubscribe. Can not be null.
     */
    void unsubscribe(Object listener);
}
