package gg.warcraft.monolith.app.entity.event;

import gg.warcraft.monolith.api.entity.EntityType;
import gg.warcraft.monolith.api.entity.event.AbstractEntityEvent;
import gg.warcraft.monolith.api.entity.event.EntityRespawnEvent;

import java.util.UUID;

public class SimpleEntityRespawnEvent extends AbstractEntityEvent implements EntityRespawnEvent {

    public SimpleEntityRespawnEvent(UUID entityId, EntityType entityType) {
        super(entityId, entityType);
    }
}
