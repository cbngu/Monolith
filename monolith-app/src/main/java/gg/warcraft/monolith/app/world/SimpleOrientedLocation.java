package gg.warcraft.monolith.app.world;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import gg.warcraft.monolith.api.world.OrientedLocation;
import gg.warcraft.monolith.api.world.World;
import org.joml.Vector3f;
import org.joml.Vector3fc;

import java.util.Objects;

public class SimpleOrientedLocation extends SimpleLocation implements OrientedLocation {
    private final float pitch;
    private final float yaw;
    private final Vector3fc direction;

    public SimpleOrientedLocation(World world, float x, float y, float z, float pitch, float yaw, Vector3fc direction) {
        super(world, x, y, z);
        this.pitch = pitch;
        this.yaw = yaw;
        this.direction = direction;
    }

    public SimpleOrientedLocation(World world, float x, float y, float z, float pitch, float yaw) {
        super(world, x, y, z);
        Preconditions.checkArgument(pitch >= -90);
        Preconditions.checkArgument(pitch <= 90);
        Preconditions.checkArgument(yaw >= -180);
        Preconditions.checkArgument(yaw < 180);

        this.pitch = pitch;
        this.yaw = yaw;
        double pitchRadians = Math.toRadians(pitch);
        double yawRadians = Math.toRadians(yaw);
        double cosYaw = Math.cos(yawRadians);
        double directionX = -Math.sin(yawRadians);
        double directionY = -(cosYaw * Math.sin(pitchRadians));
        double directionZ = cosYaw * Math.cos(pitchRadians);
        this.direction = new Vector3f((float) directionX, (float) directionY, (float) directionZ);
    }

    public SimpleOrientedLocation(World world, float x, float y, float z, Vector3fc direction) {
        super(world, x, y, z);
        Vector3fc normalizedDirection = direction.normalize(new Vector3f());
        double dirX = normalizedDirection.x();
        double dirY = normalizedDirection.y();
        double dirZ = normalizedDirection.z();
        double pitchRadians = Math.asin(-dirY);
        double yawRadians = Math.atan2(dirX, dirZ);
        this.pitch = (float) Math.toDegrees(pitchRadians);
        float unboundYaw = (float) -Math.toDegrees(yawRadians);
        this.yaw = unboundYaw == -180 ? 180 : unboundYaw;
        this.direction = direction;
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
    public Vector3f getDirection() {
        return new Vector3f(direction);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        OrientedLocation other = (OrientedLocation) object;
        return Objects.equals(getWorld(), other.getWorld())
                && Objects.equals(getX(), other.getX())
                && Objects.equals(getY(), other.getY())
                && Objects.equals(getZ(), other.getZ())
                && Objects.equals(getPitch(), other.getPitch())
                && Objects.equals(getYaw(), other.getYaw());
    }

    @Override
    public int hashCode() {
        String id = getWorld().getType() + ":" +
                getX() + "," +
                getY() + "," +
                getZ() + "," +
                getPitch() + "," +
                getYaw();
        return id.hashCode();
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this.getClass())
                .add("world", getWorld().getType())
                .add("x", getX())
                .add("y", getY())
                .add("z", getZ())
                .add("pitch", getPitch())
                .add("yaw", getYaw())
                .toString();
    }
}
