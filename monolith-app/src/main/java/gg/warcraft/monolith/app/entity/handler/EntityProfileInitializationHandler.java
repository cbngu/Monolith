package gg.warcraft.monolith.app.entity.handler;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import gg.warcraft.monolith.api.entity.EntityProfile;
import gg.warcraft.monolith.api.entity.EntityType;
import gg.warcraft.monolith.api.entity.event.EntitySpawnEvent;
import gg.warcraft.monolith.api.entity.service.EntityProfileRepository;
import gg.warcraft.monolith.app.entity.SimpleEntityProfile;

import java.util.HashMap;
import java.util.UUID;

public class EntityProfileInitializationHandler {
    private final EntityProfileRepository entityProfileRepository;

    @Inject
    public EntityProfileInitializationHandler(EntityProfileRepository entityProfileRepository) {
        this.entityProfileRepository = entityProfileRepository;
    }

    @Subscribe
    public void onEntitySpawn(EntitySpawnEvent event) {
        if (event.getEntityType() != EntityType.PLAYER) {
            UUID entityId = event.getEntityId();
            EntityProfile profile = entityProfileRepository.get(entityId);
            if (profile == null) {
                EntityProfile newProfile = new SimpleEntityProfile(entityId, new HashMap<>());
                entityProfileRepository.save(newProfile);
            }
        }
    }
}
