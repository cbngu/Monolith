package gg.warcraft.monolith.app.core;

import com.google.common.eventbus.EventBus;
import com.google.inject.Singleton;
import gg.warcraft.monolith.api.core.Event;
import gg.warcraft.monolith.api.core.EventService;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Singleton
public class GuavaEventService implements EventService {
    private final EventBus bus;

    public GuavaEventService() {
        this.bus = new EventBus();
        try {
            Field dispatcherField = EventBus.class.getDeclaredField("dispatcher");
            dispatcherField.setAccessible(true);
            Class<?> dispatcherClass = dispatcherField.get(this.bus).getClass().getSuperclass();
            Method immediateDispatcher = dispatcherClass.getDeclaredMethod("immediate");
            immediateDispatcher.setAccessible(true);
            dispatcherField.set(this.bus, immediateDispatcher.invoke(null));
        } catch (Exception ex) {
            throw new IllegalStateException("Failed to initialize event service dispatcher: " + ex.getMessage());
        }
    }

    @Override
    public void publish(Event event) {
        bus.post(event);
    }

    @Override
    public void subscribe(Object listener) {
        bus.register(listener);
    }

    @Override
    public void unsubscribe(Object listener) {
        bus.unregister(listener);
    }
}
