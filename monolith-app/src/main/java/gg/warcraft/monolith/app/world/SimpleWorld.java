package gg.warcraft.monolith.app.world;

import gg.warcraft.monolith.api.world.World;
import gg.warcraft.monolith.api.world.WorldType;

import java.util.Objects;

public class SimpleWorld implements World {
    private final WorldType type;

    public SimpleWorld(WorldType type) {
        this.type = type;
    }

    @Override
    public WorldType getType() {
        return type;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        World other = (World) object;
        return Objects.equals(getType(), other.getType());
    }
}
