package gg.warcraft.monolith.api.world.block.service;

import gg.warcraft.monolith.api.world.block.BlockBuild;

import java.util.List;

/**
 * This repository is injectable, however you generally have no need for it. Use the command and query services instead.
 * <p>
 * If you feel you absolutely have to use this repository it can be used to forgo the command service and save a {@code
 * BlockBuild} to the Monolith domain directly. This repository does no safety checks whatsoever.
 */
public interface BlockBuildRepository {

    /**
     * @return All builds of the given type. Never null, but can be empty. Items are never null.
     */
    List<BlockBuild> getBuilds(String type);

    /**
     * @return The build of the given type and model. Can be null.
     */
    BlockBuild getBuild(String type, String model);
}
