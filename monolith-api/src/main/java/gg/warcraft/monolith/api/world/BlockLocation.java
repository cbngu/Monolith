package gg.warcraft.monolith.api.world;

import org.joml.Vector3i;
import org.joml.Vector3ic;

/**
 * A BlockLocation represents the location of a block. As blocks have integer coordinates this location object only
 * supports integer operations.
 */
public interface BlockLocation {

    /**
     * @return The world this location belongs to. Never null.
     */
    World getWorld();

    /**
     * @return The X coordinate of this location.
     */
    int getX();

    /**
     * @return The Y coordinate of this location.
     */
    int getY();

    /**
     * @return The Z coordinate of this location.
     */
    int getZ();

    /**
     * @param x The X scalar.
     * @param y The Y scalar.
     * @param z The Z scalar.
     * @return A new location that is the result of adding the given scalars to this location. Never null.
     */
    BlockLocation add(int x, int y, int z);

    /**
     * @param x The X scalar.
     * @param y The Y scalar.
     * @param z The Z scalar.
     * @return A new location that is the result of subtracting the given scalars to this location. Never null.
     */
    BlockLocation sub(int x, int y, int z);

    /**
     * @param vector The vector.
     * @return A new location that is the result of adding the given vector to this location. Never null.
     */
    BlockLocation add(Vector3ic vector);

    /**
     * @param vector The vector.
     * @return A new location that is the result of subtracting the given vector to this location. Never null.
     */
    BlockLocation sub(Vector3ic vector);

    /**
     * @param x The X scalar.
     * @return A new location with the X scalar as its X coordinate. Never null.
     */
    BlockLocation withX(int x);

    /**
     * @param y The Y scalar.
     * @return A new location with the Y scalar as its Y coordinate. Never null.
     */
    BlockLocation withY(int y);

    /**
     * @param z The Z scalar.
     * @return A new location with the Z scalar as its Z coordinate. Never null.
     */
    BlockLocation withZ(int z);

    /**
     * @param x The X scalar.
     * @param y The Y scalar.
     * @param z The Z scalar.
     * @return A new location with the given scalars as its coordinates. Never null.
     */
    BlockLocation with(int x, int y, int z);

    /**
     * @return This location as a 3D int vector. Never null.
     */
    Vector3i toVector();

    /**
     * @return This block location as a floating point location. Never null.
     */
    Location toLocation();
}
