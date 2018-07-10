package gg.warcraft.monolith.api.world.service;

import gg.warcraft.monolith.api.item.Item;
import gg.warcraft.monolith.api.world.Location;
import gg.warcraft.monolith.api.world.World;
import gg.warcraft.monolith.api.world.WorldType;
import gg.warcraft.monolith.api.world.block.Block;
import gg.warcraft.monolith.api.world.block.BlockType;
import gg.warcraft.monolith.api.world.block.Sign;

import java.util.List;

/**
 * This adapter is injectable, however you generally have no need for it. Use the command and query services instead.
 * <p>
 * The WorldServerAdapter abstracts world related server implementations from the Monolith domain. It can be used to
 * query blocks on the server, but also to drop items at a given location.
 */
public interface WorldServerAdapter {

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
     * @return The block in the given world at the specified coordinates.
     */
    Block getBlockAt(WorldType world, int x, int y, int z);

    /**
     * @param world The world.
     * @param x     The X coordinate.
     * @param z     The Y coordinate.
     * @return The highest non-air block in the given world at the specified coordinates.
     */
    Block getHighestBlockAt(WorldType world, int x, int z);

    /**
     * @param block The block to update.
     * @param type  The new type.
     */
    void setBlockType(Block block, BlockType type);

    /**
     * @param sign  The sign to update.
     * @param lines The new lines.
     */
    void setSignLines(Sign sign, String[] lines);

    /**
     * @param items    The items to drop.
     * @param location The location to drop at.
     */
    void dropItemsAt(List<Item> items, Location location);
}
