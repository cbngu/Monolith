package gg.warcraft.monolith.api.core;

import gg.warcraft.monolith.api.util.Cancellable;

/**
 * Task objects represent delayed or recurring tasks scheduled on the server.
 */
public interface Task extends Cancellable {

    /**
     * @return The id of this task.
     */
    int getId();

    /**
     * @return True if this task is cancelled, false otherwise.
     */
    boolean isCancelled();

    /**
     * @return True if this is running synchronously, false otherwise.
     */
    boolean isSync();
}
