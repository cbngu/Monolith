package gg.warcraft.monolith.api.world.block;

import gg.warcraft.monolith.api.world.World;

import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * BoundingBlockBox is a utility class that allows consumers to test whether a given {@code Block} lies within the
 * bounding box. BoundingBlockBox objects can be instantiated using {@code MathUtils#createBoundingBlockBox}.
 */
public interface BoundingBlockBox extends Predicate<Block> {

    /**
     * @return The world this bounding box is in.
     */
    World getWorld();

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

    /**
     * @param x The x coordinate.
     * @return A lazy stream of all blocks within this bounding box with coordinate x.
     */
    Stream<Block> sliceX(int x);

    /**
     * @param y The y coordinate.
     * @return A lazy stream of all blocks within this bounding boy with coordinate y.
     */
    Stream<Block> sliceY(int y);

    /**
     * @param z The z coordinate.
     * @return A lazy stream of all blocks within this bounding boz with coordinate z.
     */
    Stream<Block> sliceZ(int z);
}
