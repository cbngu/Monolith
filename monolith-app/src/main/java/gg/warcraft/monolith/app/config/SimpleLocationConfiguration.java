package gg.warcraft.monolith.app.config;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import gg.warcraft.monolith.api.config.LocationConfiguration;
import gg.warcraft.monolith.api.world.WorldType;

public class SimpleLocationConfiguration implements LocationConfiguration {
    private final WorldType world;
    private final float x;
    private final float y;
    private final float z;

    @JsonCreator
    public SimpleLocationConfiguration(@JsonProperty("world") WorldType world,
                                       @JsonProperty("x") float x,
                                       @JsonProperty("y") float y,
                                       @JsonProperty("z") float z) {
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public WorldType getWorld() {
        return world;
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public float getZ() {
        return z;
    }
}
