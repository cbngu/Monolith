package gg.warcraft.monolith.api.util;

import gg.warcraft.monolith.api.world.block.Block;

import java.util.function.Predicate;

/**
 * BoundingBlockBox is a utility class that allows consumers to test whether a given {@code Block} lies within the
 * bounding box. BoundingBlockBox objects can be instantiated using {@code MathUtils#createBoundingBlockBox}.
 */
public interface BoundingBlockBox extends Predicate<Block> {

    /**
     * Returns the north boundary of this bounding box.
     *
     * @return The north boundary of this bounding box.
     */
    int getNorthBoundary();

    /**
     * Returns the east boundary of this bounding box.
     *
     * @return The east boundary of this bounding box.
     */
    int getEastBoundary();

    /**
     * Returns the south boundary of this bounding box.
     *
     * @return The south boundary of this bounding box.
     */
    int getSouthBoundary();

    /**
     * Returns the west boundary of this bounding box.
     *
     * @return The west boundary of this bounding box.
     */
    int getWestBoundary();

    /**
     * Returns the upper boundary of this bounding box.
     *
     * @return The upper boundary of this bounding box.
     */
    int getUpperBoundary();

    /**
     * Returns the lower boundary of this bounding box.
     *
     * @return The lower boundary of this bounding box.
     */
    int getLowerBoundary();
}
