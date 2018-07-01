package gg.warcraft.monolith.app.world.block.build.service;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import gg.warcraft.monolith.api.world.BlockLocation;
import gg.warcraft.monolith.api.world.World;
import gg.warcraft.monolith.api.world.block.Block;
import gg.warcraft.monolith.api.world.block.BlockType;
import gg.warcraft.monolith.api.world.block.BlockUtils;
import gg.warcraft.monolith.api.world.block.BoundingBlockBox;
import gg.warcraft.monolith.api.world.block.BoundingBlockBoxFactory;
import gg.warcraft.monolith.api.world.block.Sign;
import gg.warcraft.monolith.api.world.block.build.BlockBuild;
import gg.warcraft.monolith.api.world.block.build.service.BlockBuildCommandService;
import gg.warcraft.monolith.api.world.block.build.service.BlockBuildRepository;
import gg.warcraft.monolith.api.world.service.WorldQueryService;
import gg.warcraft.monolith.app.world.block.build.SimpleBlockBuild;
import org.joml.Vector3i;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DefaultBlockBuildCommandService implements BlockBuildCommandService {
    private final WorldQueryService worldQueryService;
    private final BlockBuildRepository buildRepository;
    private final BlockUtils blockUtils;
    private final BoundingBlockBoxFactory blockBoxFactory;
    private final BoundingBlockBox buildRepositoryBoundingBox;

    @Inject
    public DefaultBlockBuildCommandService(WorldQueryService worldQueryService, BlockBuildRepository buildRepository,
                                           BlockUtils blockUtils, BoundingBlockBoxFactory blockBoxFactory,
                                           @Named("BuildRepositoryMinimumCorner") BlockLocation minimumCorner,
                                           @Named("BuildRepositoryMaximumCorner") BlockLocation maximumCorner) {
        Preconditions.checkArgument(minimumCorner.getWorld().getType() == maximumCorner.getWorld().getType(),
                "Failed to create build repository bounding box with minimum and maximum corners in different worlds.");
        this.worldQueryService = worldQueryService;
        this.buildRepository = buildRepository;
        this.blockUtils = blockUtils;
        this.blockBoxFactory = blockBoxFactory;
        this.buildRepositoryBoundingBox = blockBoxFactory.createBoundingBlockBox(minimumCorner.getWorld().getType(),
                minimumCorner.toVector(), maximumCorner.toVector());
    }

    int findMinMaxCoordinate(Set<Block> blocks, Function<Block, Integer> coordinate, BinaryOperator<Integer> reducer) {
        return blocks.stream()
                .map(coordinate)
                .reduce(reducer)
                .orElseThrow(IllegalStateException::new);
    }

    Set<Block> searchGlassFoundation(Sign sign) {
        Block attachedTo = sign.getAttachedTo();
        if (attachedTo.getType() != BlockType.GLASS) {
            return new HashSet<>();
        }

        boolean searching = true;
        Set<Block> searchedBlocks = new HashSet<>();
        Set<Block> glassBlocks = new HashSet<>();
        Set<Block> newGlassBlocks = new HashSet<>();
        newGlassBlocks.add(attachedTo);
        while (searching) {
            Set<Block> currentBlocks = newGlassBlocks.stream()
                    .flatMap(block -> blockUtils.getAdjacentBlocksXZ(block).stream())
                    .filter(block -> !searchedBlocks.contains(block))
                    .collect(Collectors.toSet());

            searchedBlocks.addAll(currentBlocks);

            newGlassBlocks = currentBlocks.stream()
                    .filter(block -> block.getType() == BlockType.GLASS)
                    .filter(block -> !glassBlocks.contains(block))
                    .collect(Collectors.toSet());
            if (newGlassBlocks.isEmpty()) {
                searching = false;
            }
            glassBlocks.addAll(newGlassBlocks);
        }
        return glassBlocks;
    }

    BoundingBlockBox getBuildBoundingBox(Sign sign) {
        Set<Block> glassBlocks = searchGlassFoundation(sign);
        if (glassBlocks.isEmpty()) {
            return null;
        }

        World world = buildRepositoryBoundingBox.getWorld();
        int minX = findMinMaxCoordinate(glassBlocks, block -> block.getLocation().getX(), Integer::min);
        int maxX = findMinMaxCoordinate(glassBlocks, block -> block.getLocation().getX(), Integer::max);
        int minZ = findMinMaxCoordinate(glassBlocks, block -> block.getLocation().getZ(), Integer::min);
        int maxZ = findMinMaxCoordinate(glassBlocks, block -> block.getLocation().getZ(), Integer::max);

        int minY = sign.getLocation().getY() + 1;
        int maxY = findMinMaxCoordinate(glassBlocks, block -> {
            Block highestBlock = worldQueryService.getHighestBlockAt(block.getLocation());
            return highestBlock.getLocation().getY();
        }, Integer::max);

        Vector3i minimumCorner = new Vector3i(minX, minY, minZ);
        Vector3i maximumCorner = new Vector3i(maxX, maxY, maxZ);
        return blockBoxFactory.createBoundingBlockBox(world.getType(), minimumCorner, maximumCorner);
    }

    BlockBuild initializeBuild(Sign sign) {
        String[] lines = sign.getLines();
        Preconditions.checkArgument(lines[0].contains(":"), "Encountered build sign with illegal type and model. " +
                "All bottom level wall mounted signs in the build repository need to have the build type and model " +
                "specified on the first sign line as type:model.");

        String[] typeAndModel = lines[0].split(":");
        String type = typeAndModel[0];
        String model = typeAndModel[1];

        BoundingBlockBox boundingBox = getBuildBoundingBox(sign);
        if (boundingBox == null) {
            return null;
        }
        return new SimpleBlockBuild(type, model, lines, boundingBox);
    }

    @Override
    public void initializeBuilds() {
        Stream<Block> floor = buildRepositoryBoundingBox.sliceY(buildRepositoryBoundingBox.getLowerBoundary());
        floor.filter(block -> block.getType() == BlockType.WALL_MOUNTED_SIGN_BLOCK)
                .map(block -> (Sign) block)
                .map(this::initializeBuild)
                .filter(Objects::nonNull)
                .forEach(buildRepository::save);
    }
}
