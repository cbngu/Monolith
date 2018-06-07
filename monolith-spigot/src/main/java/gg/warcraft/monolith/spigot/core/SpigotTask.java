package gg.warcraft.monolith.spigot.core;

import gg.warcraft.monolith.api.core.Task;
import org.bukkit.scheduler.BukkitTask;

public class SpigotTask implements Task {
    private final BukkitTask task;

    public SpigotTask(BukkitTask task) {
        this.task = task;
    }

    @Override
    public int getId() {
        return task.getTaskId();
    }

    @Override
    public boolean isCancelled() {
        return task.isCancelled();
    }

    @Override
    public boolean isSync() {
        return task.isSync();
    }

    @Override
    public void cancel() {
        if (!task.isCancelled()) {
            task.cancel();
        }
    }
}
