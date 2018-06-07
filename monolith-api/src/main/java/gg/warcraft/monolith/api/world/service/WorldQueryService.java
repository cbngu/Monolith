package gg.warcraft.monolith.api.world.service;

import gg.warcraft.monolith.api.world.BlockLocation;
import gg.warcraft.monolith.api.world.Location;
import gg.warcraft.monolith.api.world.OrientedLocation;
import gg.warcraft.monolith.api.world.WorldType;
import gg.warcraft.monolith.api.world.block.Block;
import org.joml.Vector3ic;

/**
 * This service is injectable.
 * <p>
 * The WorldQueryService serves as a point of entry into the world implementation and allows you to query locations and
 * blocks.
 */
public interface WorldQueryService {

    /**
     * Returns the location in the given world at the specified coordinates.
     *
     * @param world The world.
     * @param x     The X coordinate.
     * @param y     The Y coordinate.
     * @param z     The Z coordinate.
     * @return The location in the given world at the specified coordinates.
     */
    Location getLocation(WorldType world, float x, float y, float z);

    /**
     * Returns the location in the given world at the specified coordinates with the given orientation.
     *
     * @param world The world.
     * @param x     The X coordinate.
     * @param y     The Y coordinate.
     * @param z     The Z coordinate.
     * @param pitch The pitch.
     * @param yaw   The yaw.
     * @return The location in the given world at the specified coordinates with the given orientation.
     */
    OrientedLocation getOrientedLocation(WorldType world, float x, float y, float z, float pitch, float yaw);

    /**
     * Returns the location in the given world at the specified coordinates.
     *
     * @param world The world.
     * @param x     The X coordinate.
     * @param y     The Y coordinate.
     * @param z     The Z coordinate.
     * @return The location in the given world at the specified coordinates.
     */
    BlockLocation getBlockLocation(WorldType world, int x, int y, int z);

    /**
     * Returns the block in the given world at the specified coordinates.
     *
     * @param world The world.
     * @param x     The X coordinate.
     * @param y     The Y coordinate.
     * @param z     The Z coordinate.
     * @return The block in the given world at the specified coordinates.
     */
    Block getBlockAt(WorldType world, int x, int y, int z);

    /**
     * Returns the block in the given world at the given vector.
     *
     * @param world  The world.
     * @param vector The vector.
     * @return The block at the given vector.
     */
    Block getBlockAt(WorldType world, Vector3ic vector);

    /**
     * Returns the block at the given location.
     *
     * @param location The location.
     * @return The block at the given location.
     */
    Block getBlockAt(BlockLocation location);
}
