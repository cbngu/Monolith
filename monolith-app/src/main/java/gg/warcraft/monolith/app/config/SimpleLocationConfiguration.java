package gg.warcraft.monolith.app.config;

import gg.warcraft.monolith.api.config.LocationConfiguration;
import gg.warcraft.monolith.api.world.WorldType;

public class SimpleLocationConfiguration implements LocationConfiguration {
    private final WorldType world;
    private final float x;
    private final float y;
    private final float z;

    public SimpleLocationConfiguration() {
        this.world = null;
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public SimpleLocationConfiguration(WorldType world, float x, float y, float z) {
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
