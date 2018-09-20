package gg.warcraft.monolith.app.world.location;

import com.google.common.base.MoreObjects;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import gg.warcraft.monolith.api.world.World;
import gg.warcraft.monolith.api.world.location.BlockLocation;
import gg.warcraft.monolith.api.world.location.Location;
import org.joml.Vector3i;
import org.joml.Vector3ic;

import java.util.Objects;

public class SimpleBlockLocation implements BlockLocation {
    private final World world;
    private final int x;
    private final int y;
    private final int z;

    @Inject
    public SimpleBlockLocation(@Assisted World world,
                               @Assisted("x") int x,
                               @Assisted("y") int y,
                               @Assisted("z") int z) {
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
    public BlockLocation add(int x, int y, int z) {
        int newX = this.x + x;
        int newY = this.y + y;
        int newZ = this.z + z;
        return new SimpleBlockLocation(world, newX, newY, newZ);
    }

    @Override
    public BlockLocation sub(int x, int y, int z) {
        int newX = this.x - x;
        int newY = this.y - y;
        int newZ = this.z - z;
        return new SimpleBlockLocation(world, newX, newY, newZ);
    }

    @Override
    public BlockLocation add(Vector3ic vector) {
        int newX = x + vector.x();
        int newY = y + vector.y();
        int newZ = z + vector.z();
        return new SimpleBlockLocation(world, newX, newY, newZ);
    }

    @Override
    public BlockLocation sub(Vector3ic vector) {
        int newX = x - vector.x();
        int newY = y - vector.y();
        int newZ = z - vector.z();
        return new SimpleBlockLocation(world, newX, newY, newZ);
    }

    @Override
    public BlockLocation add(BlockLocation location) {
        int newX = x + location.getX();
        int newY = y + location.getY();
        int newZ = z + location.getZ();
        return new SimpleBlockLocation(world, newX, newY, newZ);
    }

    @Override
    public BlockLocation sub(BlockLocation location) {
        int newX = x - location.getX();
        int newY = y - location.getY();
        int newZ = z - location.getZ();
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
        BlockLocation other = (BlockLocation) object;
        return Objects.equals(getWorld(), other.getWorld())
                && Objects.equals(getX(), other.getX())
                && Objects.equals(getY(), other.getY())
                && Objects.equals(getZ(), other.getZ());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWorld().getType(), getX(), getY(), getZ());
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
    public Vector3i toVector() {
        return new Vector3i(x, y, z);
    }

    @Override
    public Location toLocation() {
        return new SimpleLocation(world, x, y, z);
    }
}
