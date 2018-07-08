package gg.warcraft.monolith.app.entity;

import gg.warcraft.monolith.api.entity.EntityData;
import gg.warcraft.monolith.api.entity.Team;

import java.util.UUID;

public class SimpleEntityData implements EntityData {
    private final UUID entityId;
    private final Team team;

    public SimpleEntityData(UUID entityId, Team team) {
        this.entityId = entityId;
        this.team = team;
    }

    @Override
    public UUID getEntityId() {
        return entityId;
    }

    @Override
    public Team getTeam() {
        return team;
    }
}
