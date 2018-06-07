package gg.warcraft.monolith.app.world;

import gg.warcraft.monolith.api.world.BlockLocation;
import gg.warcraft.monolith.api.world.Location;
import gg.warcraft.monolith.api.world.World;
import org.joml.Vector3i;
import org.joml.Vector3ic;

import java.util.Objects;

public class SimpleBlockLocation implements BlockLocation {
    private final World world;
    private final int x;
    private final int y;
    private final int z;

    public SimpleBlockLocation(World world, int x, int y, int z) {
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

    @Override
    public Vector3i toVector() {
        return new Vector3i(x, y, z);
    }

    @Override
    public BlockLocation add(int x, int y, int z) {
        var newX = this.x + x;
        var newY = this.y + y;
        var newZ = this.z + z;
        return new SimpleBlockLocation(world, newX, newY, newZ);
    }

    @Override
    public BlockLocation sub(int x, int y, int z) {
        var newX = this.x - x;
        var newY = this.y - y;
        var newZ = this.z - z;
        return new SimpleBlockLocation(world, newX, newY, newZ);
    }

    @Override
    public BlockLocation add(Vector3ic vector) {
        var newX = x + vector.x();
        var newY = y + vector.y();
        var newZ = z + vector.z();
        return new SimpleBlockLocation(world, newX, newY, newZ);
    }

    @Override
    public BlockLocation sub(Vector3ic vector) {
        var newX = x - vector.x();
        var newY = y - vector.y();
        var newZ = z - vector.z();
        return new SimpleBlockLocation(world, newX, newY, newZ);
    }

    @Override
    public BlockLocation withX(int x) {
        return new SimpleBlockLocation(world, x, y, z);
    }

    @Override
    public BlockLocation withY(int y) {
        return new SimpleBlockLocation(world, x, y, z);
    }

    @Override
    public BlockLocation withZ(int z) {
        return new SimpleBlockLocation(world, x, y, z);
    }

    @Override
    public BlockLocation with(int x, int y, int z) {
        return new SimpleBlockLocation(world, x, y, z);
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
