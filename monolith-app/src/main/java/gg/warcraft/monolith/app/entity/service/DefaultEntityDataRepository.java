package gg.warcraft.monolith.app.entity.service;

import com.google.inject.Singleton;
import gg.warcraft.monolith.api.entity.EntityData;
import gg.warcraft.monolith.api.entity.service.EntityDataRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Singleton
public class DefaultEntityDataRepository implements EntityDataRepository {
    private final Map<UUID, EntityData> entityData;

    public DefaultEntityDataRepository() {
        this.entityData = new HashMap<>();
    }

    @Override
    public EntityData get(UUID entityId) {
        return entityData.get(entityId);
    }

    @Override
    public void save(EntityData data) {
        entityData.put(data.getEntityId(), data);
    }
}
