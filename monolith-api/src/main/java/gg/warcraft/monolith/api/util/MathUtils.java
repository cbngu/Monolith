package gg.warcraft.monolith.api.util;

import gg.warcraft.monolith.api.world.block.BoundingBlockBox;
import org.joml.Vector3f;
import org.joml.Vector3ic;

/**
 * This utility is injectable.
 * <p>
 * MathUtils provides utility methods for mathematical operations. It also serves as a factory for
 * {@code BoundingBlockBox} objects.
 */
public interface MathUtils {

    /**
     * Creates a new {@code BoundingBlockBox} using the specified minimum and maximum corners.
     * <p>
     * {@code BoundingBlockBox} does some safety checks to make sure that the provided vectors are actually the minimum
     * and maximum corners and rearranges values where required. While this means that you do not have to make sure your
     * corners are correct you probably still should to avoid possible confusion.
     *
     * TODO: find better home for this factory method now that BBB is moved to world module
     *
     * @param minimumCorner The minimum corner of the bounding box.
     * @param maximumCorner The maximum corner of the bounding box.
     * @return A new {@code BoundingBlockBox} within the boundaries of the specified corners. Never null.
     */
    BoundingBlockBox createBoundingBlockBox(Vector3ic minimumCorner, Vector3ic maximumCorner);

    /**
     * @return A random float vector in 3D space of length unit. Never null.
     */
    Vector3f randomVector();

    /**
     * @return A random float vector in 2D space on the XZ plane of length unit. Never null.
     */
    Vector3f randomCircleVector();

    /**
     * @return A random angle in radians.
     */
    float randomAngle();
}
