package gg.warcraft.monolith.api.world.service;

import gg.warcraft.monolith.api.world.BlockLocation;
import gg.warcraft.monolith.api.world.Location;
import gg.warcraft.monolith.api.world.OrientedLocation;
import gg.warcraft.monolith.api.world.World;
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
     * @param type The type of world.
     * @return The world of this type.
     */
    World getWorld(WorldType type);

    /**
     * @param world The world.
     * @param x     The X coordinate.
     * @param y     The Y coordinate.
     * @param z     The Z coordinate.
     * @return The location in the given world at the specified coordinates.
     */
    Location getLocation(WorldType world, float x, float y, float z);

    /**
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
     * @param world The world.
     * @param x     The X coordinate.
     * @param y     The Y coordinate.
     * @param z     The Z coordinate.
     * @return The location in the given world at the specified coordinates.
     */
    BlockLocation getBlockLocation(WorldType world, int x, int y, int z);

    /**
     * @param world The world.
     * @param x     The X coordinate.
     * @param y     The Y coordinate.
     * @param z     The Z coordinate.
     * @return The block in the given world at the specified coordinates.
     */
    Block getBlockAt(WorldType world, int x, int y, int z);

    /**
     * @param world  The world.
     * @param vector The vector.
     * @return The block at the given vector.
     */
    Block getBlockAt(WorldType world, Vector3ic vector);

    /**
     * @param location The location.
     * @return The block at the location.
     */
    Block getBlockAt(BlockLocation location);

    /**
     * @param location The location.
     * @return The block at the location.
     */
    Block getBlockAt(Location location);

    /**
     * @param world The world.
     * @param x     The X coordinate.
     * @param z     The Y coordinate.
     * @return The highest non-air block in the given world at the specified coordinates.
     */
    Block getHighestBlockAt(WorldType world, int x, int z);

    /**
     * @param location The location.
     * @return The highest non-air block at the specified location.
     */
    Block getHighestBlockAt(BlockLocation location);
}
