package gg.warcraft.monolith.app.config;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import gg.warcraft.monolith.api.config.OrientedLocationConfiguration;
import gg.warcraft.monolith.api.world.WorldType;

public class SimpleOrientedLocationConfiguration implements OrientedLocationConfiguration {
    private final WorldType world;
    private final float x;
    private final float y;
    private final float z;
    private final float pitch;
    private final float yaw;

    @JsonCreator
    public SimpleOrientedLocationConfiguration(@JsonProperty("world") WorldType world,
                                               @JsonProperty("x") float x,
                                               @JsonProperty("y") float y,
                                               @JsonProperty("z") float z,
                                               @JsonProperty("pitch") float pitch,
                                               @JsonProperty("yaw") float yaw) {
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
        this.pitch = pitch;
        this.yaw = yaw;
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

    @Override
    public float getPitch() {
        return pitch;
    }

    @Override
    public float getYaw() {
        return yaw;
    }
}
