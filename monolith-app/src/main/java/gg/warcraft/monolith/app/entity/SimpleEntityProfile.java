package gg.warcraft.monolith.app.entity;

import gg.warcraft.monolith.api.entity.EntityProfile;
import gg.warcraft.monolith.api.entity.Team;

import java.util.UUID;

public class SimpleEntityProfile implements EntityProfile {
    private final UUID entityId;
    private final Team team;

    public SimpleEntityProfile(UUID entityId, Team team) {
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
