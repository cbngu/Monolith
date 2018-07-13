package gg.warcraft.monolith.app.config;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import gg.warcraft.monolith.api.config.BlockLocationConfiguration;
import gg.warcraft.monolith.api.world.WorldType;

public class SimpleBlockLocationConfiguration implements BlockLocationConfiguration {
    private final WorldType world;
    private final int x;
    private final int y;
    private final int z;

    @JsonCreator
    public SimpleBlockLocationConfiguration(@JsonProperty("world") WorldType world,
                                            @JsonProperty("x") int x,
                                            @JsonProperty("y") int y,
                                            @JsonProperty("z") int z) {
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
