package gg.warcraft.monolith.app.config;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import gg.warcraft.monolith.api.config.LocationConfiguration;
import gg.warcraft.monolith.api.config.PortalConfiguration;
import gg.warcraft.monolith.api.world.Direction;

public class JacksonPortalConfiguration implements PortalConfiguration {
    private final LocationConfiguration entryLocation;
    private final LocationConfiguration exitLocation;
    private final Direction exitOrientation;

    @JsonCreator
    public JacksonPortalConfiguration(@JsonProperty("entryLocation") LocationConfiguration entryLocation,
                                      @JsonProperty("exitLocation") LocationConfiguration exitLocation,
                                      @JsonProperty("exitOrientation") Direction exitOrientation) {
        this.entryLocation = entryLocation;
        this.exitLocation = exitLocation;
        this.exitOrientation = exitOrientation;
    }

    @Override
    public LocationConfiguration getEntryLocation() {
        return entryLocation;
    }

    @Override
    public LocationConfiguration getExitLocation() {
        return exitLocation;
    }

    @Override
    public Direction getExitOrientation() {
        return exitOrientation;
    }
}
