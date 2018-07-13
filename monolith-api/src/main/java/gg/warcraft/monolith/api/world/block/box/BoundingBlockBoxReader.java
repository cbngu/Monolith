package gg.warcraft.monolith.api.world.block.box;

import gg.warcraft.monolith.api.util.Offset;
import gg.warcraft.monolith.api.world.block.Block;

public interface BoundingBlockBoxReader {

    Block getBlockAt(int horizontalOffset, int verticalOffset, int depthOffset);

    Block getBlockAt(Offset offset);

    Offset getOffsetFor(Block target);
}
