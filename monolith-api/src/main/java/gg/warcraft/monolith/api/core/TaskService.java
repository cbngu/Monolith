package gg.warcraft.monolith.api.core;

import gg.warcraft.monolith.api.util.Duration;

/**
 * This service is injectable.
 * <p>
 * The TaskService allows for easy scheduling of tasks, whether delayed, recurring, asynchronous, or all of those.
 */
public interface TaskService {

    /**
     * Schedules a task to run the runnable after the delay.
     *
     * @param runnable The runnable.
     * @param delay    The delay.
     * @return The scheduled task.
     */
    Task runLater(Runnable runnable, Duration delay);

    /**
     * Schedules a task to run the runnable asynchronously after the delay.
     *
     * @param runnable The runnable.
     * @param delay    The delay.
     * @return The scheduled task.
     */
    Task runLaterAsync(Runnable runnable, Duration delay);

    /**
     * Schedules a task to run the runnable on the next tick.
     *
     * @param runnable The runnable.
     * @return The scheduled task.
     */
    Task runNextTick(Runnable runnable);

    /**
     * Schedules a task to run the runnable asynchronously on the next tick.
     *
     * @param runnable The runnable.
     * @return The scheduled task.
     */
    Task runNextTickAsync(Runnable runnable);

    /**
     * Schedules a task to run the runnable repeatedly after the delay each period.
     *
     * @param runnable The runnable.
     * @param delay    The delay.
     * @param period   The period.
     * @return The scheduled task.
     */
    Task runTask(Runnable runnable, Duration delay, Duration period);

    /**
     * Schedules a task to run the runnable repeatedly asynchronously after the delay each period.
     *
     * @param runnable The runnable.
     * @param delay    The delay.
     * @param period   The period.
     * @return The scheduled task.
     */
    Task runTaskAsync(Runnable runnable, Duration delay, Duration period);

    /**
     * Schedules a task to run the runnable on the next tick and each tick thereafter.
     *
     * @param runnable The runnable.
     * @return The scheduled task.
     */
    Task runEachTick(Runnable runnable);

    /**
     * Schedules a task to run the runnable asynchronously on the next tick and each tick thereafter.
     *
     * @param runnable The runnable.
     * @return The scheduled task.
     */
    Task runEachTickAsync(Runnable runnable);
}
