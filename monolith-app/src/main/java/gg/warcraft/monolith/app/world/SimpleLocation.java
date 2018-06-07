package gg.warcraft.monolith.app.world;

import gg.warcraft.monolith.api.world.Location;
import gg.warcraft.monolith.api.world.World;
import org.joml.Vector3f;
import org.joml.Vector3fc;

import java.util.Objects;

public class SimpleLocation implements Location {
    private final World world;
    private final float x;
    private final float y;
    private final float z;

    public SimpleLocation(World world, float x, float y, float z) {
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
    public Vector3f toVector() {
        return new Vector3f(x, y, z);
    }

    @Override
    public Location add(float x, float y, float z) {
        var newX = this.x + x;
        var newY = this.y + y;
        var newZ = this.z + z;
        return new SimpleLocation(world, newX, newY, newZ);
    }

    @Override
    public Location sub(float x, float y, float z) {
        var newX = this.x - x;
        var newY = this.y - y;
        var newZ = this.z - z;
        return new SimpleLocation(world, newX, newY, newZ);
    }

    @Override
    public Location add(Vector3fc vector) {
        var newX = x + vector.x();
        var newY = y + vector.y();
        var newZ = z + vector.z();
        return new SimpleLocation(world, newX, newY, newZ);
    }

    @Override
    public Location sub(Vector3fc vector) {
        var newX = x - vector.x();
        var newY = y - vector.y();
        var newZ = z - vector.z();
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
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        var other = (Location) object;
        return Objects.equals(getWorld(), other.getWorld())
                && Objects.equals(getX(), other.getX())
                && Objects.equals(getY(), other.getY())
                && Objects.equals(getZ(), other.getZ());
    }

    @Override
    public int hashCode() {
        var id = getWorld().getType() + ":" +
                getX() + "," +
                getY() + "," +
                getZ();
        return id.hashCode();
    }
}
