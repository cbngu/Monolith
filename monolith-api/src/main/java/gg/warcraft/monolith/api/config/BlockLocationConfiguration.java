package gg.warcraft.monolith.api.config;

import gg.warcraft.monolith.api.world.WorldType;

public interface BlockLocationConfiguration {

    WorldType getWorld();

    int getX();

    int getY();

    int getZ();
}
