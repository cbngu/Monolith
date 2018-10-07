package gg.warcraft.monolith.app.entity.event;

import java.util.UUID;

import gg.warcraft.monolith.api.entity.EntityType;
import gg.warcraft.monolith.api.entity.event.AbstractEntityEvent;
import gg.warcraft.monolith.api.entity.event.EntityGatheredEvent;

public class SimpleEntityGatheredEvent extends AbstractEntityEvent implements EntityGatheredEvent {

    public SimpleEntityGatheredEvent(UUID entityId, EntityType entityType) {
        super(entityId, entityType);
    }
}
