package gg.warcraft.monolith.app.config;

import gg.warcraft.monolith.api.config.BlockLocationConfiguration;
import gg.warcraft.monolith.api.world.WorldType;

public class SimpleBlockLocationConfiguration implements BlockLocationConfiguration {
    private final WorldType world;
    private final int x;
    private final int y;
    private final int z;

    public SimpleBlockLocationConfiguration() {
        this.world = null;
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public SimpleBlockLocationConfiguration(WorldType world, int x, int y, int z) {
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
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getZ() {
        return z;
    }
}
