package gg.warcraft.monolith.api.world.block.build;

import gg.warcraft.monolith.api.world.block.BoundingBlockBox;

/**
 * A BlockBuild represents a specifically arranged collection of blocks on the server. It is basically a {@code
 * BoundingBlockBox} with some extra data.
 */
public interface BlockBuild {

    /**
     * @return The id of this build, which is a combination of its type and model. Never null or empty.
     */
    String getId();

    /**
     * @return The type of this build. Never null or empty.
     */
    String getType();

    /**
     * @return The model of this build. Never null or empty.
     */
    String getModel();

    /**
     * @return The bounding box of this build. Never null.
     */
    BoundingBlockBox getBoundingBox();
}
