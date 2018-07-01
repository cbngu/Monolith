package gg.warcraft.monolith.app.world.block;

import gg.warcraft.monolith.api.world.BlockLocation;
import gg.warcraft.monolith.api.world.World;
import gg.warcraft.monolith.api.world.block.Block;
import gg.warcraft.monolith.api.world.block.BoundingBlockBox;
import gg.warcraft.monolith.api.world.service.WorldQueryService;
import org.joml.Vector3ic;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SimpleBoundingBlockBox implements BoundingBlockBox {
    private final World world;
    private final int minX;
    private final int maxX;
    private final int minY;
    private final int maxY;
    private final int minZ;
    private final int maxZ;

    public SimpleBoundingBlockBox(World world, Vector3ic minimumCorner, Vector3ic maximumCorner) {
        this.world = world;
        this.minX = Math.min(minimumCorner.x(), maximumCorner.x());
        this.maxX = Math.max(minimumCorner.x(), maximumCorner.x());
        this.minY = Math.min(minimumCorner.y(), maximumCorner.y());
        this.maxY = Math.max(minimumCorner.y(), maximumCorner.y());
        this.minZ = Math.min(minimumCorner.z(), maximumCorner.z());
        this.maxZ = Math.max(minimumCorner.z(), maximumCorner.z());
    }

    @Override
    public boolean test(Block block) {
        BlockLocation location = block.getLocation();
        int x = location.getX();
        int y = location.getY();
        int z = location.getZ();
        return x >= minX && x <= maxX &&
                y >= minY && y <= maxY &&
                z >= minZ && z <= maxZ;
    }

    @Override
    public World getWorld() {
        return world;
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

    @Override
    public Stream<Block> sliceX(int x) {
        WorldQueryService test;
        return IntStream
                .iterate(minY, currentY -> currentY + 1)
                .limit(maxY - minY)
                .flatMap(y -> IntStream
                        .iterate(minZ, currentZ -> currentZ + 1)
                        .limit(maxZ - minZ)
                        .map(z -> test.getBlockAt(getWorld(), x, y, z)));
    }

    @Override
    public Stream<Block> sliceY(int y) {
        WorldQueryService test;
        return IntStream
                .iterate(minX, currentX -> currentX + 1)
                .limit(maxX - minX)
                .flatMap(x -> IntStream
                        .iterate(minZ, currentZ -> currentZ + 1)
                        .limit(maxZ - minZ)
                        .map(z -> test.getBlockAt(getWorld(), x, y, z)));
    }

    @Override
    public Stream<Block> sliceZ(int z) {
        WorldQueryService test;
        return IntStream
                .iterate(minX, currentX -> currentX + 1)
                .limit(maxX - minX)
                .flatMap(x -> IntStream
                        .iterate(minY, currentY -> currentY + 1)
                        .limit(maxY - minY)
                        .map(y -> test.getBlockAt(getWorld(), x, y, z)));
    }
}
