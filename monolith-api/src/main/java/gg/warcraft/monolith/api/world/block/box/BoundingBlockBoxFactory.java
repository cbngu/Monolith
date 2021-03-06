package gg.warcraft.monolith.api.world.block.box;

import com.google.inject.assistedinject.Assisted;
import gg.warcraft.monolith.api.config.BoundingBlockBoxConfiguration;
import gg.warcraft.monolith.api.world.WorldType;
import org.joml.Vector3i;
import org.joml.Vector3ic;

/**
 * This factory is injectable.
 * <p>
 * BoundingBlockBoxFactory serves as a point of entry into the world implementation. It allows for easy creation of
 * {@code BoundingBlockBox} objects.
 */
public interface BoundingBlockBoxFactory {

    /**
     * Creates a new {@code BoundingBlockBox} using the specified minimum and maximum corners.
     * <p>
     * {@code BoundingBlockBox} does some safety checks to make sure that the provided vectors are actually the minimum
     * and maximum corners and rearranges values where required. While this means that you do not have to make sure your
     * corners are correct you probably still should to avoid possible confusion.
     *
     * @param world         The world this bounding box is in.
     * @param minimumCorner The minimum corner, inclusive, of the bounding box.
     * @param maximumCorner The maximum corner ,inclusive, of the bounding box.
     * @return A new {@code BoundingBlockBox} with boundaries at the specified corners. Never null.
     */
    BoundingBlockBox createBoundingBlockBox(WorldType world, @Assisted("minimum") Vector3ic minimumCorner,
                                            @Assisted("maximum") Vector3ic maximumCorner);

    /**
     * Creates a new {@code BoundingBlockBox} from the configuration.
     * <p>
     * {@code BoundingBlockBox} does some safety checks to make sure that the provided vectors are actually the minimum
     * and maximum corners and rearranges values where required. While this means that you do not have to make sure your
     * corners are correct you probably still should to avoid possible confusion.
     *
     * @param configuration The configuration from which the world, minimum corner, and maximum corner will be taken.
     *                      Can not be null.
     * @return A new {@code BoundingBlockBox} with boundaries as specified in the configuration. Never null.
     */
    default BoundingBlockBox createBoundingBlockBox(BoundingBlockBoxConfiguration configuration) {
        WorldType world = configuration.getWorld();
        Vector3ic minimumCorner = new Vector3i(
                configuration.getMinimumcorner().getX(),
                configuration.getMinimumcorner().getY(),
                configuration.getMinimumcorner().getZ());
        Vector3ic maximumCorner = new Vector3i(
                configuration.getMaximumcorner().getX(),
                configuration.getMaximumcorner().getY(),
                configuration.getMaximumcorner().getZ());
        return createBoundingBlockBox(world, minimumCorner, maximumCorner);
    }
}
