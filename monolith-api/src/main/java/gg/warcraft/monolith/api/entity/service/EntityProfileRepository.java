package gg.warcraft.monolith.api.entity.service;

import gg.warcraft.monolith.api.entity.EntityProfile;

import java.util.UUID;

public interface EntityProfileRepository {

    EntityProfile get(UUID entityId);

    void save(EntityProfile profile);

    void delete(UUID entityId);
}
