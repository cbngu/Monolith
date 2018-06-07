package gg.warcraft.monolith.api.world.service;

import gg.warcraft.monolith.api.world.ItemType;
import gg.warcraft.monolith.api.world.Location;
import gg.warcraft.monolith.api.world.block.Block;
import gg.warcraft.monolith.api.world.block.BlockType;

import java.util.List;

/**
 * This service is injectable.
 * <p>
 * The WorldCommandService serves as a point of entry into the world module implementation. It allows for easy updating
 * of block types and dropping items at a location.
 */
public interface WorldCommandService {

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
