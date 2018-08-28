package gg.warcraft.monolith.api.entity.event;

import gg.warcraft.monolith.api.world.location.Location;

public interface EntityPreSpawnEvent extends EntityPreEvent {

    Location getLocation();
}
