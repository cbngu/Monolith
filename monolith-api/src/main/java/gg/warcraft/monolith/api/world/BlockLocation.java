package gg.warcraft.monolith.api.world;

import org.joml.Vector3i;
import org.joml.Vector3ic;

/**
 * A BlockLocation represents the location of a block. As blocks have integer coordinates this location object only
 * supports integer operations.
 */
public interface BlockLocation {

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
    int getX();

    /**
     * Returns the Y coordinate of this location.
     *
     * @return The Y coordinate of this location.
     */
    int getY();

    /**
     * Returns the Z coordinate of this location.
     *
     * @return The Z coordinate of this location.
     */
    int getZ();

    /**
     * Returns this location as a 3D int vector.
     *
     * @return This location as a 3D int vector. Never null.
     */
    Vector3i toVector();

    /**
     * Creates a new location that is the result of adding the given scalars to this location.
     *
     * @param x The X scalar.
     * @param y The Y scalar.
     * @param z The Z scalar.
     * @return A new location that is the result of adding the given scalars to this location. Never null.
     */
    BlockLocation add(int x, int y, int z);

    /**
     * Creates a new location that is the result of subtracting the given scalars to this location.
     *
     * @param x The X scalar.
     * @param y The Y scalar.
     * @param z The Z scalar.
     * @return A new location that is the result of subtracting the given scalars to this location. Never null.
     */
    BlockLocation sub(int x, int y, int z);

    /**
     * Creates a new location that is the result of adding the given vector to this location.
     *
     * @param vector The vector.
     * @return A new location that is the result of adding the given vector to this location. Never null.
     */
    BlockLocation add(Vector3ic vector);

    /**
     * Creates a new location that is the result of subtracting the given vector to this location.
     *
     * @param vector The vector.
     * @return A new location that is the result of subtracting the given vector to this location. Never null.
     */
    BlockLocation sub(Vector3ic vector);

    /**
     * Creates a new location with the X scalar as its X coordinate.
     *
     * @param x The X scalar.
     * @return A new location with the X scalar as its X coordinate. Never null.
     */
    BlockLocation withX(int x);

    /**
     * Creates a new location with the Y scalar as its Y coordinate.
     *
     * @param y The Y scalar.
     * @return A new location with the Y scalar as its Y coordinate. Never null.
     */
    BlockLocation withY(int y);

    /**
     * Creates a new location with the Z scalar as its Z coordinate.
     *
     * @param z The Z scalar.
     * @return A new location with the Z scalar as its Z coordinate. Never null.
     */
    BlockLocation withZ(int z);

    /**
     * Creates a new location with the given scalars as its coordinates.
     *
     * @param x The X scalar.
     * @param y The Y scalar.
     * @param z The Z scalar.
     * @return A new location with the given scalars as its coordinates. Never null.
     */
    BlockLocation with(int x, int y, int z);
}
