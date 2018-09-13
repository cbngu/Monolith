package gg.warcraft.monolith.app.config;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import gg.warcraft.monolith.api.config.Vector3iConfiguration;

public class JacksonVector3iConfiguration implements Vector3iConfiguration {
    private final int x;
    private final int y;
    private final int z;

    @JsonCreator
    public JacksonVector3iConfiguration(@JsonProperty("x") int x,
                                        @JsonProperty("y") int y,
                                        @JsonProperty("z") int z) {
        this.x = x;
        this.y = y;
        this.z = z;
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
