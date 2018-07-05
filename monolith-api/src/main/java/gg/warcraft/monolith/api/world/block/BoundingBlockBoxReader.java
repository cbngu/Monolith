package gg.warcraft.monolith.api.world.block;

import gg.warcraft.monolith.api.util.Offset;

public interface BoundingBlockBoxReader {

    Block getBlockAt(int horizontalOffset, int verticalOffset, int depthOffset);

    Block getBlockAt(Offset offset);

    Offset getOffsetFor(Block target);
}
