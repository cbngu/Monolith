package gg.warcraft.monolith.app.core;

import gg.warcraft.monolith.api.core.PreEvent;

public class SimplePreEvent implements PreEvent {
    private boolean cancelled;
    private boolean explicitlyAllowed;

    public SimplePreEvent(boolean cancelled) {
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
