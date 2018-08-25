package gg.warcraft.monolith.app.entity.status.service;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.core.TaskService;
import gg.warcraft.monolith.api.entity.status.Status;
import gg.warcraft.monolith.api.entity.status.StatusEffect;
import gg.warcraft.monolith.api.entity.status.service.StatusCommandService;
import gg.warcraft.monolith.api.entity.status.service.StatusRepository;
import gg.warcraft.monolith.app.entity.status.SimpleStatus;

import java.util.Set;
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
        Status status = repository.getStatus(entityId);
        Set<StatusEffect> newEffects = status.getEffects();
        if (!newEffects.contains(effect)) {
            newEffects.add(effect);
            Status newStatus = new SimpleStatus(entityId, newEffects);
            repository.save(newStatus);

            if (effect.getDuration() != null) {
                taskService.runLater(() -> removeStatusEffect(effect, entityId), effect.getDuration());
            }
        }
    }

    @Override
    public void removeStatusEffect(StatusEffect effect, UUID entityId) {
        Status status = repository.getStatus(entityId);
        Set<StatusEffect> newEffects = status.getEffects();
        if (newEffects.contains(effect)) {
            newEffects.remove(effect);
            Status newStatus = new SimpleStatus(entityId, newEffects);
            repository.save(newStatus);

            effect.onExpiry();
        }
    }
}
