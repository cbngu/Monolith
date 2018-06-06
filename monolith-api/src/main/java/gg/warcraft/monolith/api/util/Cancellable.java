package gg.warcraft.monolith.api.util;

/**
 * Cancellable allows implementations to signal that their actions can be cancelled.
 */
public interface Cancellable {

    /**
     * Cancels this cancellable.
     * <p>
     * Cancelling an already cancelled cancellable should silently fail.
     */
    void cancel();
}
