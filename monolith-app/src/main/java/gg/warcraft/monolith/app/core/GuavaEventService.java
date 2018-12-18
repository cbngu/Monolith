package gg.warcraft.monolith.app.core;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.inject.Singleton;
import gg.warcraft.monolith.api.core.Event;
import gg.warcraft.monolith.api.core.EventService;

@Singleton
public class GuavaEventService implements EventService {
    private final EventBus bus;

    public GuavaEventService() {
        // regardless of this being an async bus the newDirectExecutorService publishes events on the calling
        // thread and as such will behave as a synchronous bus in a strictly synchronous application.
        this.bus = new AsyncEventBus(MoreExecutors.newDirectExecutorService());
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
