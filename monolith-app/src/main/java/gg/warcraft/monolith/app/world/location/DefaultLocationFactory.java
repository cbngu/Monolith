package gg.warcraft.monolith.app.world.location;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.world.World;
import gg.warcraft.monolith.api.world.WorldType;
import gg.warcraft.monolith.api.world.location.BlockLocation;
import gg.warcraft.monolith.api.world.location.Location;
import gg.warcraft.monolith.api.world.location.LocationFactory;
import gg.warcraft.monolith.api.world.location.OrientedLocation;
import gg.warcraft.monolith.api.world.service.WorldQueryService;

public class DefaultLocationFactory implements LocationFactory {
    private final WorldQueryService worldQueryService;

    @Inject
    public DefaultLocationFactory(WorldQueryService worldQueryService) {
        this.worldQueryService = worldQueryService;
    }

    @Override
    public Location createLocation(WorldType world, float x, float y, float z) {
        World actualWorld = worldQueryService.getWorld(world);
        return new SimpleLocation(actualWorld, x, y, z);
    }

    @Override
    public BlockLocation createBlockLocation(WorldType world, int x, int y, int z) {
        World actualWorld = worldQueryService.getWorld(world);
        return new SimpleBlockLocation(actualWorld, x, y, z);
    }

    @Override
    public OrientedLocation createOrientedLocation(WorldType world, float x, float y, float z, float pitch, float yaw) {
        World actualWorld = worldQueryService.getWorld(world);
        return new SimpleOrientedLocation(actualWorld, x, y, z, pitch, yaw);
    }
}
