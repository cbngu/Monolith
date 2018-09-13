package gg.warcraft.monolith.api.config;

import gg.warcraft.monolith.api.world.Direction;

public interface PortalConfiguration {

    LocationConfiguration getEntryLocation();

    LocationConfiguration getExitLocation();

    Direction getExitOrientation();
}
