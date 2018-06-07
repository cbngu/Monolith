package gg.warcraft.monolith.api.world.service;

import gg.warcraft.monolith.api.world.ItemType;
import gg.warcraft.monolith.api.world.Location;
import gg.warcraft.monolith.api.world.WorldType;
import gg.warcraft.monolith.api.world.block.Block;
import gg.warcraft.monolith.api.world.block.BlockType;

import java.util.List;

/**
 * This adapter is injectable, however you generally have no need for it. Use the command and query services instead.
 * <p>
 * The WorldServerAdapter abstracts world related server implementations from the Monolith domain. It can be used to
 * query blocks on the server, but also to drop items at a given location.
 */
public interface WorldServerAdapter {

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
     * Updates the block to the block type.
     *
     * @param block The block.
     * @param type  The block type.
     */
    void setBlockType(Block block, BlockType type);

    /**
     * Drops the items at the location.
     *
     * @param items    The items.
     * @param location The location.
     */
    void dropItemsAt(List<ItemType> items, Location location);
}
