package gg.warcraft.monolith.app.util;

import com.google.common.base.MoreObjects;
import gg.warcraft.monolith.api.util.Offset;

import java.util.Objects;

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

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Offset other = (Offset) object;
        return Objects.equals(getHorizontalOffset(), other.getHorizontalOffset())
                && Objects.equals(getVerticalOffset(), other.getVerticalOffset())
                && Objects.equals(getDepthOffset(), other.getDepthOffset());
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this.getClass())
                .add("horizontalOffset", getHorizontalOffset())
                .add("verticalOffset", getVerticalOffset())
                .add("depthOffset", getHorizontalOffset())
                .toString();
    }
}
