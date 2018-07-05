package gg.warcraft.monolith.api.world.block;

import gg.warcraft.monolith.api.util.Offset;

import java.util.List;

public interface BoundingBlockBoxReader {

    Block getBlockAt(int horizontalOffset, int verticalOffset, int depthOffset);

    Block getBlockAt(Offset offset);

    Offset getOffsetFor(Block target);

    List<Block> getBlocksOfType(BlockType... type);
}
