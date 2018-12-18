package gg.warcraft.monolith.app.entity.service;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import gg.warcraft.monolith.api.core.PersistenceService;
import gg.warcraft.monolith.api.entity.service.EntityRepository;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Singleton
public class DefaultEntityRepository implements EntityRepository {
    private static final String MARKED_FOR_REMOVAL_IDS_KEY = "entity:readonly:markedforremoval";

    private final PersistenceService persistenceService;

    @Inject
    public DefaultEntityRepository(PersistenceService persistenceService) {
        this.persistenceService = persistenceService;
    }

    @Override
    public Set<UUID> getMarkedForRemoval() {
        return persistenceService.getSet(MARKED_FOR_REMOVAL_IDS_KEY).stream()
                .map(UUID::fromString)
                .collect(Collectors.toSet());
    }

    @Override
    public void markForRemoval(UUID entityId) {
        String entityIdAsString = entityId.toString();
        Set<String> entityIds = persistenceService.getSet(MARKED_FOR_REMOVAL_IDS_KEY);
        if (entityIds.add(entityId.toString())) {
            List<String> valuesToAdd = Collections.singletonList(entityIdAsString);
            persistenceService.addSet(MARKED_FOR_REMOVAL_IDS_KEY, valuesToAdd);
        }
    }

    @Override
    public void delete(List<UUID> entityIds) {
        List<String> entityIdsAsString = entityIds.stream()
                .map(Object::toString)
                .collect(Collectors.toList());
        persistenceService.removeSet(MARKED_FOR_REMOVAL_IDS_KEY, entityIdsAsString);
    }
}
