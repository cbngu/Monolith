package gg.warcraft.monolith.app.entity.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import gg.warcraft.monolith.api.core.PersistenceService;
import gg.warcraft.monolith.api.entity.EntityProfile;
import gg.warcraft.monolith.api.entity.service.EntityProfileRepository;
import gg.warcraft.monolith.app.entity.SimpleEntityProfile;
import gg.warcraft.monolith.app.entity.persistence.EntityProfileItem;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Singleton
public class DefaultEntityProfileRepository implements EntityProfileRepository {
    private static final String PROFILE_KEY_PREFIX = "entityprofile:";

    private final PersistenceService persistenceService;
    private final ObjectMapper jsonMapper;

    @Inject
    public DefaultEntityProfileRepository(PersistenceService persistenceService, ObjectMapper jsonMapper) {
        this.persistenceService = persistenceService;
        this.jsonMapper = jsonMapper;
    }

    String createProfileKey(UUID playerId) {
        return PROFILE_KEY_PREFIX + playerId;
    }

    EntityProfile mapItemToProfile(EntityProfileItem item) {
        UUID entityId = item.getEntityId();
        Map<String, String> data = item.getData();
        return new SimpleEntityProfile(entityId, data);
    }

    @Override
    public EntityProfile get(UUID entityId) {
        String profileKey = createProfileKey(entityId);
        String profileJson = persistenceService.get(profileKey);
        if (profileJson == null) {
            return null;
        }

        try {
            EntityProfileItem profileItem = jsonMapper.readValue(profileJson, EntityProfileItem.class);
            return mapItemToProfile(profileItem);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    EntityProfileItem mapProfileToItem(EntityProfile profile) {
        UUID entityId = profile.getEntityId();
        Map<String, String> data = profile.getData();
        return new EntityProfileItem(entityId, data);
    }

    @Override
    public void save(EntityProfile profile) {
        String profileKey = createProfileKey(profile.getEntityId());
        EntityProfileItem profileItem = mapProfileToItem(profile);
        try {
            String profileJson = jsonMapper.writeValueAsString(profileItem);
            persistenceService.set(profileKey, profileJson);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
