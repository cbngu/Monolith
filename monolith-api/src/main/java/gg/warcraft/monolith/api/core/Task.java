package gg.warcraft.monolith.api.core;

import gg.warcraft.monolith.api.util.Cancellable;

/**
 * Task objects represent delayed or recurring tasks scheduled on the server.
 */
public interface Task extends Cancellable {

    /**
     * Returns the id of this task.
     *
     * @return The id of this task.
     */
    int getId();

    /**
     * Returns whether or not this task is cancelled.
     *
     * @return True if this task is cancelled, false otherwise.
     */
    boolean isCancelled();

    /**
     * Returns whether or not this task is running synchronously.
     *
     * @return True if this is running synchronously, false otherwise.
     */
    boolean isSync();
}
