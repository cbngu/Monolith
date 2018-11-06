package gg.warcraft.monolith.app.entity.event;

import gg.warcraft.monolith.api.entity.EntityType;
import gg.warcraft.monolith.api.entity.event.AbstractEntityEvent;
import gg.warcraft.monolith.api.entity.event.EntityDespawnEvent;

import java.util.UUID;

public class SimpleEntityDespawnEvent extends AbstractEntityEvent implements EntityDespawnEvent {

    public SimpleEntityDespawnEvent(UUID entityId, EntityType entityType) {
        super(entityId, entityType);
    }
}
