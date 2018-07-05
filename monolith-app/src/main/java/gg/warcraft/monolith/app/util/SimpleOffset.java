package gg.warcraft.monolith.app.util;

import gg.warcraft.monolith.api.util.Offset;

public class SimpleOffset implements Offset {
    private final Number horizontalOffset;
    private final Number verticalOffset;
    private final Number depthOffset;

    public SimpleOffset(Number horizontalOffset, Number verticalOffset, Number depthOffset) {
        this.horizontalOffset = horizontalOffset;
        this.verticalOffset = verticalOffset;
        this.depthOffset = depthOffset;
    }

    @Override
    public Number getHorizontalOffset() {
        return horizontalOffset;
    }

    @Override
    public Number getVerticalOffset() {
        return verticalOffset;
    }

    @Override
    public Number getDepthOffset() {
        return depthOffset;
    }
}
