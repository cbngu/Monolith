package gg.warcraft.monolith.app.entity.status.service;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.core.TaskService;
import gg.warcraft.monolith.api.entity.status.StatusEffect;
import gg.warcraft.monolith.api.entity.status.service.StatusCommandService;
import gg.warcraft.monolith.api.entity.status.service.StatusRepository;
import gg.warcraft.monolith.app.entity.status.SimpleStatus;

import java.util.HashSet;
import java.util.UUID;

public class DefaultStatusCommandService implements StatusCommandService {
    private final StatusRepository repository;
    private final TaskService taskService;

    @Inject
    public DefaultStatusCommandService(StatusRepository repository, TaskService taskService) {
        this.repository = repository;
        this.taskService = taskService;
    }

    @Override
    public void addStatusEffect(StatusEffect effect, UUID entityId) {
        var status = repository.getStatus(entityId);
        var effects = status.getEffects();
        if (!effects.contains(effect)) {
            var newEffects = new HashSet<>(effects);
            newEffects.add(effect);
            var newStatus = new SimpleStatus(entityId, newEffects);
            repository.save(newStatus);
            taskService.runLater(() -> removeStatusEffect(effect, entityId), effect.getDuration());
        }
    }

    @Override
    public void removeStatusEffect(StatusEffect effect, UUID entityId) {
        var status = repository.getStatus(entityId);
        var effects = status.getEffects();
        if (effects.contains(effect)) {
            var newEffects = new HashSet<>(effects);
            newEffects.remove(effect);
            var newStatus = new SimpleStatus(entityId, newEffects);
            repository.save(newStatus);
        }
    }
}
