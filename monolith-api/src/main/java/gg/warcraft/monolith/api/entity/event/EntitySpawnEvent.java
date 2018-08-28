package gg.warcraft.monolith.api.entity.event;

import gg.warcraft.monolith.api.world.location.Location;

public interface EntitySpawnEvent extends EntityEvent {

    Location getLocation();
}
