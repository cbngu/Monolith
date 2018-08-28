package gg.warcraft.monolith.api.world.location;

import com.google.inject.assistedinject.Assisted;
import com.google.inject.name.Named;
import gg.warcraft.monolith.api.config.BlockLocationConfiguration;
import gg.warcraft.monolith.api.config.LocationConfiguration;
import gg.warcraft.monolith.api.config.OrientedLocationConfiguration;
import gg.warcraft.monolith.api.world.WorldType;
import org.joml.Vector3fc;

public interface LocationFactory {

    /**
     * @param world The world.
     * @param x     The X coordinate.
     * @param y     The Y coordinate.
     * @param z     The Z coordinate.
     * @return The location in the given world at the specified coordinates. Never null.
     */
    @Named("location")
    Location createLocation(WorldType world,
                            @Assisted("x") float x,
                            @Assisted("y") float y,
                            @Assisted("z") float z);

    /**
     * @param configuration The location configuration. Can not be null.
     * @return The location in the given world at the coordinates specified in the configuration. Never null.
     */
    default Location createLocation(LocationConfiguration configuration) {
        return createLocation(
                configuration.getWorld(),
                configuration.getX(),
                configuration.getY(),
                configuration.getZ());
    }

    /**
     * @param world The world.
     * @param x     The X coordinate.
     * @param y     The Y coordinate.
     * @param z     The Z coordinate.
     * @return The block location in the given world at the specified coordinates. Never null.
     */
    @Named("block")
    BlockLocation createBlockLocation(WorldType world,
                                      @Assisted("x") int x,
                                      @Assisted("y") int y,
                                      @Assisted("z") int z);

    /**
     * @param configuration The block location configuration. Can not be null.
     * @return The location in the given world at the coordinates specified in the configuration. Never null.
     */
    default BlockLocation createBlockLocation(BlockLocationConfiguration configuration) {
        return createBlockLocation(
                configuration.getWorld(),
                configuration.getX(),
                configuration.getY(),
                configuration.getZ());
    }

    /**
     * @param world The world.
     * @param x     The X coordinate.
     * @param y     The Y coordinate.
     * @param z     The Z coordinate.
     * @param pitch The orientation pitch.
     * @param yaw   The orientation yaw.
     * @return The oriented location in the given world at the specified coordinates with the specified orientation.
     * Never null.
     */
    @Named("oriented")
    OrientedLocation createOrientedLocation(WorldType world,
                                            @Assisted("x") float x,
                                            @Assisted("y") float y,
                                            @Assisted("z") float z,
                                            @Assisted("pitch") float pitch,
                                            @Assisted("yaw") float yaw);

    /**
     * @param configuration The oriented location configuration. Can not be null.
     * @return The oriented location in the given world at the coordinates and with the orientation specified in the
     * configuration. Never null.
     */
    default OrientedLocation createOrientedLocation(OrientedLocationConfiguration configuration) {
        return createOrientedLocation(
                configuration.getWorld(),
                configuration.getX(),
                configuration.getY(),
                configuration.getZ(),
                configuration.getPitch(),
                configuration.getYaw());
    }

    /**
     * @param world     The world.
     * @param x         The X coordinate.
     * @param y         The Y coordinate.
     * @param z         The Z coordinate.
     * @param direction The orientation direction.
     * @return The oriented location in the given world at the specified coordinates with the specified orientation.
     * Never null.
     */
    OrientedLocation createOrientedLocation(WorldType world, float x, float y, float z, Vector3fc direction);
}
