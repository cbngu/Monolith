package gg.warcraft.monolith.api.config;

import gg.warcraft.monolith.api.world.WorldType;

public interface LocationConfiguration {

    WorldType getWorld();

    float getX();

    float getY();

    float getZ();
}
