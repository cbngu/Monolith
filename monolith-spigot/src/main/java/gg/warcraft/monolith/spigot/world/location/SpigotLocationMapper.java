package gg.warcraft.monolith.spigot.world.location;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.world.World;
import gg.warcraft.monolith.api.world.location.BlockLocation;
import gg.warcraft.monolith.api.world.location.Location;
import gg.warcraft.monolith.api.world.location.OrientedLocation;
import gg.warcraft.monolith.app.world.location.SimpleBlockLocation;
import gg.warcraft.monolith.app.world.location.SimpleLocation;
import gg.warcraft.monolith.app.world.location.SimpleOrientedLocation;
import gg.warcraft.monolith.spigot.world.SpigotWorldMapper;
import org.bukkit.entity.LivingEntity;
import org.joml.Vector3f;

public class SpigotLocationMapper {
    private final SpigotWorldMapper worldMapper;

    @Inject
    public SpigotLocationMapper(SpigotWorldMapper worldMapper) {
        this.worldMapper = worldMapper;
    }

    public org.bukkit.Location map(Location location) {
        if (location instanceof OrientedLocation) {
            OrientedLocation orientedLocation = (OrientedLocation) location;
            org.bukkit.World world = worldMapper.map(location.getWorld());
            float x = location.getX();
            float y = location.getY();
            float z = location.getZ();
            float pitch = orientedLocation.getPitch();
            float yaw = orientedLocation.getYaw();
            return new org.bukkit.Location(world, x, y, z, yaw, pitch);
        }

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
        Vector3f direction = new Vector3f(
                (float) location.getDirection().getX(),
                (float) location.getDirection().getY(),
                (float) location.getDirection().getZ());
        return new SimpleOrientedLocation(
                worldMapper.map(location.getWorld()),
                (float) location.getX(),
                (float) location.getY(),
                (float) location.getZ(),
                location.getPitch(),
                location.getYaw(),
                direction);
    }

    public OrientedLocation mapEye(LivingEntity entity) {
        org.bukkit.Location location = entity.getEyeLocation();
        Vector3f direction = new Vector3f(
                (float) location.getDirection().getX(),
                (float) location.getDirection().getY(),
                (float) location.getDirection().getZ());
        return new SimpleOrientedLocation(
                worldMapper.map(location.getWorld()),
                (float) location.getX(),
                (float) location.getY(),
                (float) location.getZ(),
                location.getPitch(),
                location.getYaw(),
                direction);
    }
}
