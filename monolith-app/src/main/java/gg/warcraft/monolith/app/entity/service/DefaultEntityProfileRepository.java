package gg.warcraft.monolith.app.entity.service;

import com.google.inject.Singleton;
import gg.warcraft.monolith.api.entity.EntityProfile;
import gg.warcraft.monolith.api.entity.service.EntityProfileRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Singleton
public class DefaultEntityProfileRepository implements EntityProfileRepository {
    private final Map<UUID, EntityProfile> entityData;

    public DefaultEntityProfileRepository() {
        this.entityData = new HashMap<>();
    }

    @Override
    public EntityProfile get(UUID entityId) {
        return entityData.get(entityId);
    }

    @Override
    public void save(EntityProfile data) {
        entityData.put(data.getEntityId(), data);
    }
}
