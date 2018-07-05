package gg.warcraft.monolith.app.world.block;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.util.Offset;
import gg.warcraft.monolith.api.util.TriFunction;
import gg.warcraft.monolith.api.world.Direction;
import gg.warcraft.monolith.api.world.WorldType;
import gg.warcraft.monolith.api.world.block.Block;
import gg.warcraft.monolith.api.world.block.BoundingBlockBox;
import gg.warcraft.monolith.api.world.block.BoundingBlockBoxReader;
import gg.warcraft.monolith.api.world.service.WorldQueryService;
import gg.warcraft.monolith.app.util.SimpleOffset;

import java.util.function.Function;

public class SimpleBoundingBlockBoxReader implements BoundingBlockBoxReader {
    private final BoundingBlockBox boundingBlockBox;

    final TriFunction<Integer, Integer, Integer, Block> readBlockAt;
    final Function<Block, Offset> readOffsetFor;

    @Inject
    public SimpleBoundingBlockBoxReader(WorldQueryService worldQueryService, BoundingBlockBox boundingBlockBox,
                                        Direction readDirection) {
        this.boundingBlockBox = boundingBlockBox;

        WorldType world = boundingBlockBox.getWorld().getType();
        switch (readDirection) {
            case NORTH:
                readBlockAt = (horizontalOffset, verticalOffset, depthOffset) -> {
                    int x = boundingBlockBox.getWestBoundary() + horizontalOffset;
                    int y = boundingBlockBox.getLowerBoundary() + verticalOffset;
                    int z = boundingBlockBox.getSouthBoundary() - depthOffset;
                    return worldQueryService.getBlockAt(world, x, y, z);
                };
                readOffsetFor = (block) -> {
                    int xOffset = block.getLocation().getX() - boundingBlockBox.getWestBoundary();
                    int yOffset = block.getLocation().getY() - boundingBlockBox.getLowerBoundary();
                    int zOffset = boundingBlockBox.getSouthBoundary() - block.getLocation().getZ();
                    return new SimpleOffset(xOffset, yOffset, zOffset);
                };
                break;
            case EAST:
                readBlockAt = (horizontalOffset, verticalOffset, depthOffset) -> {
                    int x = boundingBlockBox.getWestBoundary() + depthOffset;
                    int y = boundingBlockBox.getLowerBoundary() + verticalOffset;
                    int z = boundingBlockBox.getNorthBoundary() + horizontalOffset;
                    return worldQueryService.getBlockAt(world, x, y, z);
                };
                readOffsetFor = (block) -> {
                    int xOffset = block.getLocation().getX() - boundingBlockBox.getWestBoundary();
                    int yOffset = block.getLocation().getY() - boundingBlockBox.getLowerBoundary();
                    int zOffset = block.getLocation().getZ() - boundingBlockBox.getSouthBoundary();
                    return new SimpleOffset(zOffset, yOffset, xOffset);
                };
                break;
            case SOUTH:
                readBlockAt = (horizontalOffset, verticalOffset, depthOffset) -> {
                    int x = boundingBlockBox.getEastBoundary() - horizontalOffset;
                    int y = boundingBlockBox.getLowerBoundary() + verticalOffset;
                    int z = boundingBlockBox.getNorthBoundary() + depthOffset;
                    return worldQueryService.getBlockAt(world, x, y, z);
                };
                readOffsetFor = (block) -> {
                    int xOffset = boundingBlockBox.getEastBoundary() - block.getLocation().getX();
                    int yOffset = block.getLocation().getY() - boundingBlockBox.getLowerBoundary();
                    int zOffset = block.getLocation().getZ() - boundingBlockBox.getNorthBoundary();
                    return new SimpleOffset(xOffset, yOffset, zOffset);
                };
                break;
            case WEST:
                readBlockAt = (horizontalOffset, verticalOffset, depthOffset) -> {
                    int x = boundingBlockBox.getEastBoundary() - depthOffset;
                    int y = boundingBlockBox.getLowerBoundary() + verticalOffset;
                    int z = boundingBlockBox.getSouthBoundary() - horizontalOffset;
                    return worldQueryService.getBlockAt(world, x, y, z);
                };
                readOffsetFor = (block) -> {
                    int xOffset = boundingBlockBox.getEastBoundary() - block.getLocation().getX();
                    int yOffset = block.getLocation().getY() - boundingBlockBox.getLowerBoundary();
                    int zOffset = boundingBlockBox.getSouthBoundary() - block.getLocation().getZ();
                    return new SimpleOffset(zOffset, yOffset, xOffset);
                };
                break;
            case UP:
            case DOWN:
            default:
                throw new IllegalArgumentException("Failed to initialize bounding block box reader with illegal read direction " + readDirection);
        }
    }

    @Override
    public Block getBlockAt(int horizontalOffset, int verticalOffset, int depthOffset) {
        return readBlockAt.apply(horizontalOffset, verticalOffset, depthOffset);
    }

    @Override
    public Block getBlockAt(Offset offset) {
        return getBlockAt(offset.getHorizontalOffset().intValue(),
                offset.getDepthOffset().intValue(),
                offset.getVerticalOffset().intValue());
    }

    @Override
    public Offset getOffsetFor(Block target) {
        return readOffsetFor.apply(target);
    }
}
