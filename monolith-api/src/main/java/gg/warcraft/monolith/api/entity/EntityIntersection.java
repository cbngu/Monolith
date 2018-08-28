package gg.warcraft.monolith.api.entity;

import gg.warcraft.monolith.api.world.location.Location;

public interface EntityIntersection {

    /**
     * @return The entity that was intersected. Never null.
     */
    Entity getEntity();

    /**
     * @return The exact location where this entity's bounding box was intersected. Never null.
     */
    Location getLocation();
}
