package gg.warcraft.monolith.api.entity.service;

import gg.warcraft.monolith.api.entity.EntityData;

import java.util.UUID;

public interface EntityDataRepository {

    EntityData get(UUID entityId);

    void save(EntityData data);
}
