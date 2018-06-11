package gg.warcraft.monolith.spigot.world;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.world.BlockLocation;
import gg.warcraft.monolith.api.world.Location;
import gg.warcraft.monolith.api.world.OrientedLocation;
import gg.warcraft.monolith.api.world.World;
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
        org.bukkit.World world = worldMapper.map(location.getWorld());
        float x = location.getX();
        float y = location.getY();
        float z = location.getZ();
        return new org.bukkit.Location(world, x, y, z);
    }

    public org.bukkit.Location map(BlockLocation location) {
        org.bukkit.World world = worldMapper.map(location.getWorld());
        float x = location.getX();
        float y = location.getY();
        float z = location.getZ();
        return new org.bukkit.Location(world, x, y, z);
    }

    public Location map(org.bukkit.Location location) {
        World world = worldMapper.map(location.getWorld());
        float x = (float) location.getX();
        float y = (float) location.getY();
        float z = (float) location.getZ();
        return new SimpleLocation(world, x, y, z);
    }

    public BlockLocation map(org.bukkit.block.Block block) {
        World world = worldMapper.map(block.getLocation().getWorld());
        int x = block.getX();
        int y = block.getY();
        int z = block.getZ();
        return new SimpleBlockLocation(world, x, y, z);
    }

    public OrientedLocation map(LivingEntity entity) {
        org.bukkit.Location location = entity.getLocation();
        World world = worldMapper.map(location.getWorld());
        float x = (float) location.getX();
        float y = (float) location.getY();
        float z = (float) location.getZ();
        float pitch = location.getPitch();
        float yaw = location.getYaw();
        return new SimpleOrientedLocation(world, x, y, z, pitch, yaw);
    }

    public OrientedLocation mapEye(LivingEntity entity) {
        org.bukkit.Location location = entity.getEyeLocation();
        World world = worldMapper.map(location.getWorld());
        float x = (float) location.getX();
        float y = (float) location.getY();
        float z = (float) location.getZ();
        float pitch = location.getPitch();
        float yaw = location.getYaw();
        return new SimpleOrientedLocation(world, x, y, z, pitch, yaw);
    }
}
