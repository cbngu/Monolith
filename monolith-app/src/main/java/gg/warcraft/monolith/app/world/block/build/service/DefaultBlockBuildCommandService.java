package gg.warcraft.monolith.app.world.block.build.service;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import gg.warcraft.monolith.api.util.MathUtils;
import gg.warcraft.monolith.api.world.BlockLocation;
import gg.warcraft.monolith.api.world.block.BoundingBlockBox;
import gg.warcraft.monolith.api.world.block.build.service.BlockBuildCommandService;

public class DefaultBlockBuildCommandService implements BlockBuildCommandService {
    private final BoundingBlockBox buildRepositoryBoundingBox;

    @Inject
    public DefaultBlockBuildCommandService(MathUtils mathUtils,
                                           @Named("BuildRepositoryMinimumCorner") BlockLocation minimumCorner,
                                           @Named("BuildRepositoryMaximumCorner") BlockLocation maximumCorner) {
        this.buildRepositoryBoundingBox = mathUtils.createBoundingBlockBox(minimumCorner.toVector(),
                maximumCorner.toVector());
    }

    @Override
    public void initializeBuilds() {
        int floor = buildRepositoryBoundingBox.getLowerBoundary();

    }
}
