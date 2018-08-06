package gg.warcraft.monolith.app.entity.status.service;

import com.google.inject.Singleton;
import gg.warcraft.monolith.api.entity.status.Status;
import gg.warcraft.monolith.api.entity.status.service.StatusRepository;
import gg.warcraft.monolith.app.entity.status.SimpleStatus;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Singleton
public class DefaultStatusRepository implements StatusRepository {
    final Map<UUID, Status> statuses;

    public DefaultStatusRepository() {
        this.statuses = new HashMap<>();
    }

    @Override
    public Status getStatus(UUID entityId) {
        return statuses.computeIfAbsent(entityId, id -> new SimpleStatus(id, Collections.emptySet()));
    }

    @Override
    public void save(Status status) {
        statuses.put(status.getEntityId(), status);
    }

    @Override
    public void delete(UUID entityId) {
        statuses.remove(entityId);
    }
}
