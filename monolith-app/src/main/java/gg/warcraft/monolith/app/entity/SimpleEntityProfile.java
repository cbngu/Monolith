package gg.warcraft.monolith.app.entity;

import gg.warcraft.monolith.api.entity.EntityProfile;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class SimpleEntityProfile implements EntityProfile {
    private final UUID entityId;
    private final Map<String, String> data;

    public SimpleEntityProfile(UUID entityId, Map<String, String> data) {
        this.entityId = checkNotNull(entityId);
        this.data = checkNotNull(data);

        checkArgument(!data.containsKey(null));
        checkArgument(!data.containsKey(""));
        checkArgument(!data.containsValue(null));
        checkArgument(!data.containsValue(""));
    }

    @Override
    public UUID getEntityId() {
        return entityId;
    }

    @Override
    public Map<String, String> getData() {
        return new HashMap<>(data);
    }
}
