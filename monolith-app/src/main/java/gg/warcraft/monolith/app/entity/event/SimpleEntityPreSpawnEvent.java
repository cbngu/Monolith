package gg.warcraft.monolith.app.entity.event;

import gg.warcraft.monolith.api.entity.EntityType;
import gg.warcraft.monolith.api.entity.event.AbstractEntityPreEvent;
import gg.warcraft.monolith.api.entity.event.EntityPreSpawnEvent;
import gg.warcraft.monolith.api.world.location.Location;

import java.util.UUID;

public class SimpleEntityPreSpawnEvent extends AbstractEntityPreEvent implements EntityPreSpawnEvent {
    private final Location location;

    public SimpleEntityPreSpawnEvent(UUID entityId, EntityType entityType, Location location, boolean cancelled) {
        super(entityId, entityType, cancelled);
        this.location = location;
    }

    @Override
    public Location getLocation() {
        return location;
    }
}
