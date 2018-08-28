package gg.warcraft.monolith.app.world.location;

import com.google.common.base.MoreObjects;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import gg.warcraft.monolith.api.world.World;
import gg.warcraft.monolith.api.world.location.BlockLocation;
import gg.warcraft.monolith.api.world.location.Location;
import gg.warcraft.monolith.api.world.location.OrientedLocation;
import org.joml.Vector3f;
import org.joml.Vector3fc;

import java.util.Objects;

public class SimpleLocation implements Location {
    private final World world;
    private final float x;
    private final float y;
    private final float z;

    @Inject
    public SimpleLocation(@Assisted World world,
                          @Assisted("x") float x,
                          @Assisted("y") float y,
                          @Assisted("z") float z) {
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public World getWorld() {
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
    public Location add(float x, float y, float z) {
        float newX = this.x + x;
        float newY = this.y + y;
        float newZ = this.z + z;
        return new SimpleLocation(world, newX, newY, newZ);
    }

    @Override
    public Location sub(float x, float y, float z) {
        float newX = this.x - x;
        float newY = this.y - y;
        float newZ = this.z - z;
        return new SimpleLocation(world, newX, newY, newZ);
    }

    @Override
    public Location add(Vector3fc vector) {
        float newX = x + vector.x();
        float newY = y + vector.y();
        float newZ = z + vector.z();
        return new SimpleLocation(world, newX, newY, newZ);
    }

    @Override
    public Location sub(Vector3fc vector) {
        float newX = x - vector.x();
        float newY = y - vector.y();
        float newZ = z - vector.z();
        return new SimpleLocation(world, newX, newY, newZ);
    }

    @Override
    public Location add(Location location) {
        float newX = x + location.getX();
        float newY = y + location.getY();
        float newZ = z + location.getZ();
        return new SimpleLocation(world, newX, newY, newZ);
    }

    @Override
    public Location sub(Location location) {
        float newX = x - location.getX();
        float newY = y - location.getY();
        float newZ = z - location.getZ();
        return new SimpleLocation(world, newX, newY, newZ);
    }

    @Override
    public Location withX(float x) {
        return new SimpleLocation(world, x, y, z);
    }

    @Override
    public Location withY(float y) {
        return new SimpleLocation(world, x, y, z);
    }

    @Override
    public Location withZ(float z) {
        return new SimpleLocation(world, x, y, z);
    }

    @Override
    public Location with(float x, float y, float z) {
        return new SimpleLocation(world, x, y, z);
    }

    @Override
    public OrientedLocation withOrientation(float pitch, float yaw) {
        return new SimpleOrientedLocation(world, x, y, z, pitch, yaw);
    }

    @Override
    public OrientedLocation withDirection(Vector3fc direction) {
        return new SimpleOrientedLocation(world, x, y, z, direction);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Location other = (Location) object;
        return Objects.equals(getWorld(), other.getWorld())
                && Objects.equals(getX(), other.getX())
                && Objects.equals(getY(), other.getY())
                && Objects.equals(getZ(), other.getZ());
    }

    @Override
    public int hashCode() {
        String id = getWorld().getType() + ":" +
                getX() + "," +
                getY() + "," +
                getZ();
        return id.hashCode();
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this.getClass())
                .add("world", getWorld().getType())
                .add("x", getX())
                .add("y", getY())
                .add("z", getZ())
                .toString();
    }

    @Override
    public Vector3f toVector() {
        return new Vector3f(x, y, z);
    }

    @Override
    public BlockLocation toBlockLocation() {
        return new SimpleBlockLocation(world, (int) x, (int) y, (int) z);
    }
}
