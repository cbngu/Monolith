package gg.warcraft.monolith.api.world.block;

import gg.warcraft.monolith.api.util.Offset;

import java.util.List;

public interface BlockReader {

    Block getBlockAt(int widthOffset, int depthOffset, int heightOffset);

    Offset getOffsetFor(Block target);

    List<Block> getBlocksOfType(BlockType... type);

    default Block getBlockAt(Offset offset) {
        return getBlockAt(offset.getHorizontalOffset().intValue(),
                offset.getDepthOffset().intValue(),
                offset.getVerticalOffset().intValue());
    }
}
