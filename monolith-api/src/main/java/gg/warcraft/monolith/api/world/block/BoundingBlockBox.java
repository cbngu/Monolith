package gg.warcraft.monolith.api.world.block;

import java.util.function.Predicate;

/**
 * BoundingBlockBox is a utility class that allows consumers to test whether a given {@code Block} lies within the
 * bounding box. BoundingBlockBox objects can be instantiated using {@code MathUtils#createBoundingBlockBox}.
 */
public interface BoundingBlockBox extends Predicate<Block> {

    /**
     * @return The north boundary of this bounding box.
     */
    int getNorthBoundary();

    /**
     * @return The east boundary of this bounding box.
     */
    int getEastBoundary();

    /**
     * @return The south boundary of this bounding box.
     */
    int getSouthBoundary();

    /**
     * @return The west boundary of this bounding box.
     */
    int getWestBoundary();

    /**
     * @return The upper boundary of this bounding box.
     */
    int getUpperBoundary();

    /**
     * @return The lower boundary of this bounding box.
     */
    int getLowerBoundary();
}
