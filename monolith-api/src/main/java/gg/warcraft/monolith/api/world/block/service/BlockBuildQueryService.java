package gg.warcraft.monolith.api.world.block.service;

import gg.warcraft.monolith.api.world.block.BlockBuild;

import java.util.List;

/**
 * This service is injectable.
 * <p>
 * The BlockBuildQueryService serves as a point of entry into the build implementation. It provides methods to query the
 * Monolith domain for a {@code BlockBuild} by type and model.
 */
public interface BlockBuildQueryService {

    /**
     * @return All builds of the given type. Never null, but can be empty. Items are never null.
     */
    List<BlockBuild> getBuilds(String type);

    /**
     * @return The build of the given type and model. Can be null.
     */
    BlockBuild getBuild(String type, String model);
}
