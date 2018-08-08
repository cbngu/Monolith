package gg.warcraft.monolith.app.effect;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import gg.warcraft.monolith.api.core.Task;
import gg.warcraft.monolith.api.core.TaskService;
import gg.warcraft.monolith.api.effect.Effect;
import gg.warcraft.monolith.api.effect.EffectRenderer;
import gg.warcraft.monolith.api.util.Duration;
import gg.warcraft.monolith.api.util.TimeUtils;
import gg.warcraft.monolith.api.world.Location;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Supplier;

public class SimpleEffect implements Effect {
    private final TaskService taskService;
    private final Supplier<Location> location;
    private final Collection<EffectRenderer> renderers;
    private final Task task;

    @Inject
    public SimpleEffect(TaskService taskService, TimeUtils timeUtils,
                        @Assisted Supplier<Location> location) {
        this(taskService, timeUtils, location, timeUtils.oneTick());
    }

    @Inject
    public SimpleEffect(TaskService taskService, TimeUtils timeUtils,
                        @Assisted Supplier<Location> location, @Assisted Duration period) {
        this.taskService = taskService;
        this.location = location;
        this.renderers = new ArrayList<>();
        this.task = taskService.runTask(this, timeUtils.oneTick(), period);
    }

    public Location getLocation() {
        return location.get();
    }

    public void addRenderer(EffectRenderer renderer) {
        renderers.add(renderer);
    }

    public void clearRenderers() {
        renderers.clear();
    }

    @Override
    public void run() {
        Location currentLocation = getLocation();
        renderers.forEach(renderer -> renderer.renderAt(currentLocation));
    }

    @Override
    public void cancel() {
        if (!task.isCancelled()) {
            task.cancel();
        }
    }

    public void cancel(Duration delay) {
        taskService.runLater(this::cancel, delay);
    }
}
