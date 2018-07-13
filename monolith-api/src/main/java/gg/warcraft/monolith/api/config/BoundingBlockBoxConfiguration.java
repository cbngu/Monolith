package gg.warcraft.monolith.api.config;

import gg.warcraft.monolith.api.world.WorldType;

public interface BoundingBlockBoxConfiguration {

    WorldType getWorld();

    Vector3iConfiguration getMinimumcorner();

    Vector3iConfiguration getMaximumcorner();
}
