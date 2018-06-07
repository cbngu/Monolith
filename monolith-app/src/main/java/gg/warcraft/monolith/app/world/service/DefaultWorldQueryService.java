package gg.warcraft.monolith.app.world.service;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.world.BlockLocation;
import gg.warcraft.monolith.api.world.Location;
import gg.warcraft.monolith.api.world.OrientedLocation;
import gg.warcraft.monolith.api.world.WorldType;
import gg.warcraft.monolith.api.world.block.Block;
import gg.warcraft.monolith.api.world.service.WorldQueryService;
import gg.warcraft.monolith.api.world.service.WorldServerAdapter;
import gg.warcraft.monolith.app.world.SimpleBlockLocation;
import gg.warcraft.monolith.app.world.SimpleLocation;
import gg.warcraft.monolith.app.world.SimpleOrientedLocation;
import gg.warcraft.monolith.app.world.SimpleWorld;
import org.joml.Vector3ic;

public class DefaultWorldQueryService implements WorldQueryService {
    private final WorldServerAdapter serverAdapter;

    @Inject
    public DefaultWorldQueryService(WorldServerAdapter serverAdapter) {
        this.serverAdapter = serverAdapter;
    }

    @Override
    public Location getLocation(WorldType world, float x, float y, float z) {
        var actualWorld = new SimpleWorld(world);
        return new SimpleLocation(actualWorld, x, y, z);
    }

    @Override
    public OrientedLocation getOrientedLocation(WorldType world, float x, float y, float z, float pitch, float yaw) {
        var actualWorld = new SimpleWorld(world);
        return new SimpleOrientedLocation(actualWorld, x, y, z, pitch, yaw);
    }

    @Override
    public BlockLocation getBlockLocation(WorldType world, int x, int y, int z) {
        var actualWorld = new SimpleWorld(world);
        return new SimpleBlockLocation(actualWorld, x, y, z);
    }

    @Override
    public Block getBlockAt(WorldType world, int x, int y, int z) {
        return serverAdapter.getBlockAt(world, x, y, z);
    }

    @Override
    public Block getBlockAt(WorldType world, Vector3ic vector) {
        return serverAdapter.getBlockAt(world, vector.x(), vector.y(), vector.z());
    }

    @Override
    public Block getBlockAt(BlockLocation location) {
        return serverAdapter.getBlockAt(location.getWorld().getType(),
                location.getX(), location.getY(), location.getZ());
    }
}
