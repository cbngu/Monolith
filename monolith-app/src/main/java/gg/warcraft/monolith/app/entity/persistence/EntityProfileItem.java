package gg.warcraft.monolith.app.entity.persistence;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.UUID;

public class EntityProfileItem {
    private final UUID entityId;
    private final Map<String, String> data;

    @JsonCreator
    public EntityProfileItem(@JsonProperty("entityId") UUID entityId,
                             @JsonProperty("data") Map<String, String> data) {
        this.entityId = entityId;
        this.data = data;
    }

    public UUID getEntityId() {
        return entityId;
    }

    public Map<String, String> getData() {
        return data;
    }
}
