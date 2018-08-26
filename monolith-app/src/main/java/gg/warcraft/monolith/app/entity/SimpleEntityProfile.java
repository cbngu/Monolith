package gg.warcraft.monolith.app.entity;

import gg.warcraft.monolith.api.entity.EntityProfile;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SimpleEntityProfile implements EntityProfile {
    private final UUID entityId;
    private final String team;
    private final Map<String, String> data;

    public SimpleEntityProfile(UUID entityId, String team, Map<String, String> data) {
        this.entityId = entityId;
        this.team = team;
        this.data = data;
    }

    @Override
    public UUID getEntityId() {
        return entityId;
    }

    @Override
    public String getTeam() {
        return team;
    }

    @Override
    public Map<String, String> getData() {
        return new HashMap<>(data);
    }
}
