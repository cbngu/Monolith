package gg.warcraft.monolith.api.util;

/**
 * Cancellable allows implementations to signal that their actions can be cancelled.
 */
public interface Cancellable {

    /**
     * Cancels this cancellable if not already cancelled, should silently fail otherwise.
     */
    void cancel();
}
