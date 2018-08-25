package gg.warcraft.monolith.api.core.event;

import gg.warcraft.monolith.api.core.PreEvent;

public abstract class AbstractPreEvent implements PreEvent {
    private boolean cancelled;
    private boolean explicitlyAllowed;

    public AbstractPreEvent(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public boolean isExplicitlyAllowed() {
        return explicitlyAllowed;
    }

    @Override
    public void cancel() {
        cancelled = true;
    }

    @Override
    public void explicitlyAllow() {
        explicitlyAllowed = true;
    }
}
