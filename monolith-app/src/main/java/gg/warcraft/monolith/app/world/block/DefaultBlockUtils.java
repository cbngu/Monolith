package gg.warcraft.monolith.app.world.block;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.world.BlockLocation;
import gg.warcraft.monolith.api.world.Location;
import gg.warcraft.monolith.api.world.block.Block;
import gg.warcraft.monolith.api.world.block.BlockFace;
import gg.warcraft.monolith.api.world.block.BlockIntersection;
import gg.warcraft.monolith.api.world.block.BlockIterator;
import gg.warcraft.monolith.api.world.block.BlockIteratorFactory;
import gg.warcraft.monolith.api.world.block.BlockType;
import gg.warcraft.monolith.api.world.block.BlockUtils;
import gg.warcraft.monolith.api.world.service.WorldQueryService;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class DefaultBlockUtils implements BlockUtils {
    private final WorldQueryService worldQueryService;
    private final BlockIteratorFactory blockIteratorFactory;

    @Inject
    public DefaultBlockUtils(WorldQueryService worldQueryService, BlockIteratorFactory blockIteratorFactory) {
        this.worldQueryService = worldQueryService;
        this.blockIteratorFactory = blockIteratorFactory;
    }

    @Override
    public Set<Block> getAdjacentBlocks(Block block) {
        Set<Block> adjacentBlocks = new HashSet<>();
        adjacentBlocks.addAll(getAdjacentBlocksX(block));
        adjacentBlocks.addAll(getAdjacentBlocksY(block));
        adjacentBlocks.addAll(getAdjacentBlocksZ(block));
        return adjacentBlocks;
    }

    @Override
    public Set<Block> getAdjacentBlocks(Block block, BlockType type) {
        return getAdjacentBlocks(block).stream()
                .filter(adjacentBlock -> adjacentBlock.getType() == type)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Block> getAdjacentBlocksX(Block block) {
        Set<Block> blocks = new HashSet<>();
        BlockLocation location = block.getLocation();
        int currentX = location.getX();

        BlockLocation leftNeighbourLocation = location.withX(currentX - 1);
        Block leftNeighbour = worldQueryService.getBlockAt(leftNeighbourLocation);
        blocks.add(leftNeighbour);

        BlockLocation rightNeighbourLocation = location.withX(currentX + 1);
        Block rightNeighbour = worldQueryService.getBlockAt(rightNeighbourLocation);
        blocks.add(rightNeighbour);

        return blocks;
    }

    @Override
    public Set<Block> getAdjacentBlocksY(Block block) {
        Set<Block> blocks = new HashSet<>();
        BlockLocation location = block.getLocation();
        int currentY = location.getY();

        BlockLocation leftNeighbourLocation = location.withY(currentY - 1);
        Block leftNeighbour = worldQueryService.getBlockAt(leftNeighbourLocation);
        blocks.add(leftNeighbour);

        BlockLocation rightNeighbourLocation = location.withY(currentY + 1);
        Block rightNeighbour = worldQueryService.getBlockAt(rightNeighbourLocation);
        blocks.add(rightNeighbour);

        return blocks;
    }

    @Override
    public Set<Block> getAdjacentBlocksZ(Block block) {
        Set<Block> blocks = new HashSet<>();
        BlockLocation location = block.getLocation();
        int currentZ = location.getZ();

        BlockLocation leftNeighbourLocation = location.withZ(currentZ - 1);
        Block leftNeighbour = worldQueryService.getBlockAt(leftNeighbourLocation);
        blocks.add(leftNeighbour);

        BlockLocation rightNeighbourLocation = location.withZ(currentZ + 1);
        Block rightNeighbour = worldQueryService.getBlockAt(rightNeighbourLocation);
        blocks.add(rightNeighbour);

        return blocks;
    }

    @Override
    public Set<Block> getAdjacentBlocksXY(Block block) {
        Set<Block> adjacentBlocks = new HashSet<>();
        adjacentBlocks.addAll(getAdjacentBlocksX(block));
        adjacentBlocks.addAll(getAdjacentBlocksY(block));
        return adjacentBlocks;
    }

    @Override
    public Set<Block> getAdjacentBlocksXZ(Block block) {
        Set<Block> adjacentBlocks = new HashSet<>();
        adjacentBlocks.addAll(getAdjacentBlocksX(block));
        adjacentBlocks.addAll(getAdjacentBlocksZ(block));
        return adjacentBlocks;
    }

    @Override
    public Set<Block> getAdjacentBlocksYZ(Block block) {
        Set<Block> adjacentBlocks = new HashSet<>();
        adjacentBlocks.addAll(getAdjacentBlocksY(block));
        adjacentBlocks.addAll(getAdjacentBlocksZ(block));
        return adjacentBlocks;
    }

    @Override
    public Block getRelative(Block block, BlockFace at) {
        BlockLocation location = block.getLocation();
        int currentX = location.getX();
        int currentY = location.getY();
        int currentZ = location.getZ();
        switch (at) {
            case NORTH:
                BlockLocation northLocation = location.withZ(currentZ - 1);
                return worldQueryService.getBlockAt(northLocation);
            case EAST:
                BlockLocation eastLocation = location.withX(currentX + 1);
                return worldQueryService.getBlockAt(eastLocation);
            case SOUTH:
                BlockLocation southLocation = location.withZ(currentZ + 1);
                return worldQueryService.getBlockAt(southLocation);
            case WEST:
                BlockLocation westLocation = location.withX(currentX - 1);
                return worldQueryService.getBlockAt(westLocation);
            case UP:
                BlockLocation upLocation = location.withY(currentY + 1);
                return worldQueryService.getBlockAt(upLocation);
            case DOWN:
                BlockLocation downLocation = location.withY(currentY - 1);
                return worldQueryService.getBlockAt(downLocation);
            default:
                throw new IllegalArgumentException("Failed to get relative block for illegal block face " + at);
        }
    }

    @Override
    public BlockIntersection intersectBlock(Location origin, Location target, Set<BlockType> ignore) {
        BlockIterator blockIterator = blockIteratorFactory.createBlockIterator(origin, target);
        while (blockIterator.hasNext()) {
            Block currentBlock = blockIterator.next();
            if (!ignore.contains(currentBlock.getType())) {
                Location intersection = blockIterator.calculateIntersection();
                return new SimpleBlockIntersection(currentBlock, null, intersection);
            }
        }
        return null;
    }
}
