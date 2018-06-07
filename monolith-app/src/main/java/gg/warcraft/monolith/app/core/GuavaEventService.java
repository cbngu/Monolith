package gg.warcraft.monolith.app.core;

import com.google.common.eventbus.EventBus;
import com.google.inject.Singleton;
import gg.warcraft.monolith.api.core.Event;
import gg.warcraft.monolith.api.core.EventService;

@Singleton
public class GuavaEventService implements EventService {
    private final EventBus bus;

    public GuavaEventService() {
        this.bus = new EventBus();
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
