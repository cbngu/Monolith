package gg.warcraft.monolith.app.config;

import gg.warcraft.monolith.api.config.OrientedLocationConfiguration;
import gg.warcraft.monolith.api.world.WorldType;

public class SimpleOrientedLocationConfiguration implements OrientedLocationConfiguration {
    private final WorldType world;
    private final float x;
    private final float y;
    private final float z;
    private final float pitch;
    private final float yaw;

    public SimpleOrientedLocationConfiguration() {
        this.world = null;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.pitch = 0;
        this.yaw = 0;
    }

    public SimpleOrientedLocationConfiguration(WorldType world, float x, float y, float z, float pitch, float yaw) {
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
        return 0;
    }

    @Override
    public float getYaw() {
        return 0;
    }
}
