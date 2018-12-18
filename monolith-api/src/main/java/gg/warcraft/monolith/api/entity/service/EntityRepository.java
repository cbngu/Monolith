package gg.warcraft.monolith.api.entity.service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface EntityRepository {

    Set<UUID> getMarkedForRemoval();

    void markForRemoval(UUID entityId);

    void delete(List<UUID> entityIds);
}
