package gg.warcraft.monolith.api.world.block;

import java.util.Set;

public interface BlockUtils {

    /**
     * @param block The block. Can not be null.
     * @return All blocks adjacent to the block. Never null or empty.
     */
    Set<Block> getAdjacentBlocks(Block block);

    /**
     * @param block The block. Can not be null.
     * @return All blocks adjacent to the block along the X axis. Never null or empty.
     */
    Set<Block> getAdjacentBlocksX(Block block);

    /**
     * @param block The block. Can not be null.
     * @return All blocks adjacent to the block along the Y axis. Never null or empty.
     */
    Set<Block> getAdjacentBlocksY(Block block);

    /**
     * @param block The block. Can not be null.
     * @return All blocks adjacent to the block along the Z axis. Never null or empty.
     */
    Set<Block> getAdjacentBlocksZ(Block block);

    /**
     * @param block The block. Can not be null.
     * @return All blocks adjacent to the block along the X and Y axes. Never null or empty.
     */
    Set<Block> getAdjacentBlocksXY(Block block);

    /**
     * @param block The block. Can not be null.
     * @return All blocks adjacent to the block along the X and Z axes. Never null or empty.
     */
    Set<Block> getAdjacentBlocksXZ(Block block);

    /**
     * @param block The block. Can not be null.
     * @return All blocks adjacent to the block along the Y and Z axes. Never null or empty.
     */
    Set<Block> getAdjacentBlocksYZ(Block block);

    /**
     * @param block The block. Can not be null.
     * @param at    The block face. Can not be null.
     * @return The block neighbouring this block at the given block face. Never null.
     */
    Block getRelative(Block block, BlockFace at);
}
