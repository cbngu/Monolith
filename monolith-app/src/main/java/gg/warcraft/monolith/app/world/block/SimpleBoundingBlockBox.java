package gg.warcraft.monolith.app.world.block;

import gg.warcraft.monolith.api.world.block.Block;
import gg.warcraft.monolith.api.world.block.BoundingBlockBox;
import org.joml.Vector3ic;

public class SimpleBoundingBlockBox implements BoundingBlockBox {
    private final int minX;
    private final int maxX;
    private final int minY;
    private final int maxY;
    private final int minZ;
    private final int maxZ;

    public SimpleBoundingBlockBox(Vector3ic minimumCorner, Vector3ic maximumCorner) {
        this.minX = Math.min(minimumCorner.x(), maximumCorner.x());
        this.maxX = Math.max(minimumCorner.x(), maximumCorner.x());
        this.minY = Math.min(minimumCorner.y(), maximumCorner.y());
        this.maxY = Math.max(minimumCorner.y(), maximumCorner.y());
        this.minZ = Math.min(minimumCorner.z(), maximumCorner.z());
        this.maxZ = Math.max(minimumCorner.z(), maximumCorner.z());
    }

    @Override
    public boolean test(Block block) {
        var location = block.getLocation();
        var x = location.getX();
        var y = location.getY();
        var z = location.getZ();
        return x >= minX && x <= maxX &&
                y >= minY && y <= maxY &&
                z >= minZ && z <= maxZ;
    }

    @Override
    public int getNorthBoundary() {
        return minZ;
    }

    @Override
    public int getEastBoundary() {
        return maxX;
    }

    @Override
    public int getSouthBoundary() {
        return maxZ;
    }

    @Override
    public int getWestBoundary() {
        return minX;
    }

    @Override
    public int getUpperBoundary() {
        return maxY;
    }

    @Override
    public int getLowerBoundary() {
        return minY;
    }
}
