package gg.warcraft.monolith.api.world.location;

import gg.warcraft.monolith.api.world.World;
import org.joml.Vector3f;
import org.joml.Vector3fc;

/**
 * A Location represents a location in a world.
 */
public interface Location {

    /**
     * @return The world this location belongs to. Never null.
     */
    World getWorld();

    /**
     * @return The X coordinate of this location.
     */
    float getX();

    /**
     * @return The Y coordinate of this location.
     */
    float getY();

    /**
     * @return The Z coordinate of this location.
     */
    float getZ();

    /**
     * @param x The X scalar.
     * @param y The Y scalar.
     * @param z The Z scalar.
     * @return A new location that is the result of adding the given scalars to this location. Never null.
     */
    Location add(float x, float y, float z);

    /**
     * @param x The X scalar.
     * @param y The Y scalar.
     * @param z The Z scalar.
     * @return A new location that is the result of subtracting the given scalars from this location. Never null.
     */
    Location sub(float x, float y, float z);

    /**
     * @param vector The vector.
     * @return A new location that is the result of adding the given vector to this location. Never null.
     */
    Location add(Vector3fc vector);

    /**
     * @param vector The vector.
     * @return A new location that is the result of subtracting the given vector from this location. Never null.
     */
    Location sub(Vector3fc vector);

    /**
     * @param location The location.
     * @return A new location that is the result of adding the given location to this location. Never null.
     */
    Location add(Location location);

    /**
     * @param location The location.
     * @return A new location that is the result of subtracting the given location from this location. Never null.
     */
    Location sub(Location location);

    /**
     * @param x The X scalar.
     * @return A new location with the X scalar as its X coordinate. Never null.
     */
    Location withX(float x);

    /**
     * @param y The Y scalar.
     * @return A new location with the Y scalar as its Y coordinate. Never null.
     */
    Location withY(float y);

    /**
     * @param z The Z scalar.
     * @return A new location with the Z scalar as its Z coordinate. Never null.
     */
    Location withZ(float z);

    /**
     * @param x The X scalar.
     * @param y The Y scalar.
     * @param z The Z scalar.
     * @return A new location with the given scalars as its coordinates. Never null.
     */
    Location with(float x, float y, float z);

    /**
     * @param pitch The pitch.
     * @param yaw   The yaw.
     * @return A new oriented location at the position of this location with the given pitch and yaw. Never null.
     */
    OrientedLocation withOrientation(float pitch, float yaw);

    /**
     * @param direction The direction vector. Can not be null.
     * @return A new oriented location at the position of this location with the given direction. Never null.
     */
    OrientedLocation withDirection(Vector3fc direction);

    /**
     * @return This location as a 3D int vector. Never null.
     */
    Vector3f toVector();

    /**
     * @return This location as a block location. Never null.
     */
    BlockLocation toBlockLocation();
}
