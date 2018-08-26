package gg.warcraft.monolith.app.entity.persistence;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.UUID;

public class EntityProfileItem {
    private final UUID entityId;
    private final String team;
    private final Map<String, String> data;

    @JsonCreator
    public EntityProfileItem(@JsonProperty("entityId") UUID entityId,
                             @JsonProperty("team") String team,
                             @JsonProperty("data") Map<String, String> data) {
        this.entityId = entityId;
        this.team = team;
        this.data = data;
    }

    public UUID getEntityId() {
        return entityId;
    }

    public String getTeam() {
        return team;
    }

    public Map<String, String> getData() {
        return data;
    }
}
