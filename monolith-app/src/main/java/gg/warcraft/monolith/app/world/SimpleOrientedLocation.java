package gg.warcraft.monolith.app.world;

import gg.warcraft.monolith.api.world.OrientedLocation;
import gg.warcraft.monolith.api.world.World;

import java.util.Objects;

public class SimpleOrientedLocation extends SimpleLocation implements OrientedLocation {
    private final float pitch;
    private final float yaw;

    public SimpleOrientedLocation(World world, float x, float y, float z, float pitch, float yaw) {
        super(world, x, y, z);
        this.pitch = pitch;
        this.yaw = yaw;
    }

    @Override
    public float getPitch() {
        return pitch;
    }

    @Override
    public float getYaw() {
        return yaw;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        var other = (OrientedLocation) object;
        return Objects.equals(getWorld(), other.getWorld())
                && Objects.equals(getX(), other.getX())
                && Objects.equals(getY(), other.getY())
                && Objects.equals(getZ(), other.getZ())
                && Objects.equals(getPitch(), other.getPitch())
                && Objects.equals(getYaw(), other.getYaw());
    }

    @Override
    public int hashCode() {
        var id = getWorld().getType() + ":" +
                getX() + "," +
                getY() + "," +
                getZ() + "," +
                getPitch() + "," +
                getYaw();
        return id.hashCode();
    }
}
