package gg.warcraft.monolith.app.config;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import gg.warcraft.monolith.api.config.BoundingBlockBoxConfiguration;
import gg.warcraft.monolith.api.config.Vector3iConfiguration;
import gg.warcraft.monolith.api.world.WorldType;

public class SimpleBoundingBlockBoxConfiguration implements BoundingBlockBoxConfiguration {
    private final WorldType world;
    private final Vector3iConfiguration minimumCorner;
    private final Vector3iConfiguration maximumCorner;

    @JsonCreator
    public SimpleBoundingBlockBoxConfiguration(@JsonProperty("world") WorldType world,
                                               @JsonProperty("minimumCorner") Vector3iConfiguration minimumCorner,
                                               @JsonProperty("maximumCorner") Vector3iConfiguration maximumCorner) {
        this.world = world;
        this.minimumCorner = minimumCorner;
        this.maximumCorner = maximumCorner;
    }

    @Override
    public WorldType getWorld() {
        return world;
    }

    @Override
    public Vector3iConfiguration getMinimumcorner() {
        return minimumCorner;
    }

    @Override
    public Vector3iConfiguration getMaximumcorner() {
        return maximumCorner;
    }
}
