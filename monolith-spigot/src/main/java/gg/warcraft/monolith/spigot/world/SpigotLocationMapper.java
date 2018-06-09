package gg.warcraft.monolith.spigot.world;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.world.BlockLocation;
import gg.warcraft.monolith.api.world.Location;
import gg.warcraft.monolith.api.world.OrientedLocation;
import gg.warcraft.monolith.app.world.SimpleBlockLocation;
import gg.warcraft.monolith.app.world.SimpleLocation;
import gg.warcraft.monolith.app.world.SimpleOrientedLocation;
import org.bukkit.entity.LivingEntity;

public class SpigotLocationMapper {
    private final SpigotWorldMapper worldMapper;

    @Inject
    public SpigotLocationMapper(SpigotWorldMapper worldMapper) {
        this.worldMapper = worldMapper;
    }

    public org.bukkit.Location map(Location location) {
        var world = worldMapper.map(location.getWorld());
        var x = location.getX();
        var y = location.getY();
        var z = location.getZ();
        return new org.bukkit.Location(world, x, y, z);
    }

    public org.bukkit.Location map(BlockLocation location) {
        var world = worldMapper.map(location.getWorld());
        var x = location.getX();
        var y = location.getY();
        var z = location.getZ();
        return new org.bukkit.Location(world, x, y, z);
    }

    public Location map(org.bukkit.Location location) {
        var world = worldMapper.map(location.getWorld());
        var x = (float) location.getX();
        var y = (float) location.getY();
        var z = (float) location.getZ();
        return new SimpleLocation(world, x, y, z);
    }

    public BlockLocation map(org.bukkit.block.Block block) {
        var world = worldMapper.map(block.getLocation().getWorld());
        var x = block.getX();
        var y = block.getY();
        var z = block.getZ();
        return new SimpleBlockLocation(world, x, y, z);
    }

    public OrientedLocation map(LivingEntity entity) {
        var location = entity.getLocation();
        var world = worldMapper.map(location.getWorld());
        var x = (float) location.getX();
        var y = (float) location.getY();
        var z = (float) location.getZ();
        var pitch = location.getPitch();
        var yaw = location.getYaw();
        return new SimpleOrientedLocation(world, x, y, z, pitch, yaw);
    }

    public OrientedLocation mapEye(LivingEntity entity) {
        var location = entity.getEyeLocation();
        var world = worldMapper.map(location.getWorld());
        var x = (float) location.getX();
        var y = (float) location.getY();
        var z = (float) location.getZ();
        var pitch = location.getPitch();
        var yaw = location.getYaw();
        return new SimpleOrientedLocation(world, x, y, z, pitch, yaw);
    }
}
