package gg.warcraft.monolith.api.world.service;

import gg.warcraft.monolith.api.item.Item;
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
     * @param block The block to update.
     * @param type  The type to update to.
     */
    void setBlockType(Block block, BlockType type);

    /**
     * @param items    The items to drop.
     * @param location The location to drop at.
     */
    void dropItemsAt(List<Item> items, Location location);
}
