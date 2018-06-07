package gg.warcraft.monolith.api.world;

import org.joml.Vector3f;
import org.joml.Vector3fc;

/**
 * A Location represents a location in a world.
 */
public interface Location {

    /**
     * Returns the world this location belongs to.
     *
     * @return The world this location belongs to. Never null.
     */
    World getWorld();

    /**
     * Returns the X coordinate of this location.
     *
     * @return The X coordinate of this location.
     */
    float getX();

    /**
     * Returns the Y coordinate of this location.
     *
     * @return The Y coordinate of this location.
     */
    float getY();

    /**
     * Returns the Z coordinate of this location.
     *
     * @return The Z coordinate of this location.
     */
    float getZ();

    /**
     * Returns this location as a 3D int vector.
     *
     * @return This location as a 3D int vector. Never null.
     */
    Vector3f toVector();

    /**
     * Creates a new location that is the result of adding the given scalars to this location.
     *
     * @param x The X scalar.
     * @param y The Y scalar.
     * @param z The Z scalar.
     * @return A new location that is the result of adding the given scalars to this location. Never null.
     */
    Location add(float x, float y, float z);

    /**
     * Creates a new location that is the result of subtracting the given scalars to this location.
     *
     * @param x The X scalar.
     * @param y The Y scalar.
     * @param z The Z scalar.
     * @return A new location that is the result of subtracting the given scalars to this location. Never null.
     */
    Location sub(float x, float y, float z);

    /**
     * Creates a new location that is the result of adding the given vector to this location.
     *
     * @param vector The vector.
     * @return A new location that is the result of adding the given vector to this location. Never null.
     */
    Location add(Vector3fc vector);

    /**
     * Creates a new location that is the result of subtracting the given vector to this location.
     *
     * @param vector The vector.
     * @return A new location that is the result of subtracting the given vector to this location. Never null.
     */
    Location sub(Vector3fc vector);

    /**
     * Creates a new location with the X scalar as its X coordinate.
     *
     * @param x The X scalar.
     * @return A new location with the X scalar as its X coordinate. Never null.
     */
    Location withX(float x);

    /**
     * Creates a new location with the Y scalar as its Y coordinate.
     *
     * @param y The Y scalar.
     * @return A new location with the Y scalar as its Y coordinate. Never null.
     */
    Location withY(float y);

    /**
     * Creates a new location with the Z scalar as its Z coordinate.
     *
     * @param z The Z scalar.
     * @return A new location with the Z scalar as its Z coordinate. Never null.
     */
    Location withZ(float z);

    /**
     * Creates a new location with the given scalars as its coordinates.
     *
     * @param x The X scalar.
     * @param y The Y scalar.
     * @param z The Z scalar.
     * @return A new location with the given scalars as its coordinates. Never null.
     */
    Location with(float x, float y, float z);
}
