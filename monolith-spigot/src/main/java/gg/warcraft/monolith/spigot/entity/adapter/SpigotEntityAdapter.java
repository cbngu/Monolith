package gg.warcraft.monolith.spigot.entity.adapter;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.entity.EntityServerData;
import gg.warcraft.monolith.api.entity.EntityType;
import gg.warcraft.monolith.api.entity.service.EntityServerAdapter;
import gg.warcraft.monolith.api.world.Location;
import gg.warcraft.monolith.api.world.PotionEffect;
import gg.warcraft.monolith.api.world.PotionType;
import gg.warcraft.monolith.app.entity.SimpleEntityServerData;
import gg.warcraft.monolith.spigot.entity.SpigotEntityTypeMapper;
import gg.warcraft.monolith.spigot.world.SpigotLocationMapper;
import org.bukkit.GameMode;
import org.bukkit.Server;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.joml.Vector3f;
import org.joml.Vector3fc;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class SpigotEntityAdapter implements EntityServerAdapter {
    private final Server server;
    private final SpigotEntityTypeMapper entityTypeMapper;
    private final SpigotLocationMapper locationMapper;

    @Inject
    public SpigotEntityAdapter(Server server, SpigotEntityTypeMapper entityTypeMapper,
                               SpigotLocationMapper locationMapper) {
        this.server = server;
        this.entityTypeMapper = entityTypeMapper;
        this.locationMapper = locationMapper;
    }

    EntityServerData createEntityData(LivingEntity entity) {
        var type = entityTypeMapper.map(entity.getType());
        var location = locationMapper.map(entity);
        var eyeLocation = locationMapper.mapEye(entity);
        var velocity = entity.getVelocity();
        var x = (float) velocity.getX();
        var y = (float) velocity.getY();
        var z = (float) velocity.getZ();
        return new SimpleEntityServerData(entity.getUniqueId(), type, location, eyeLocation, new Vector3f(x, y, z));
    }

    @Override
    public EntityServerData getEntityServerData(UUID entityId) {
        Entity entity = server.getEntity(entityId);
        if (entity instanceof LivingEntity) {
            return createEntityData((LivingEntity) entity);
        }
        return null;
    }

    @Override
    public List<EntityServerData> getNearbyEntitiesServerData(Location location, float deltaX, float deltaY, float deltaZ) {
        org.bukkit.Location spigotLocation = locationMapper.map(location);
        return spigotLocation.getWorld().getNearbyEntities(spigotLocation, deltaX, deltaY, deltaZ).stream()
                .filter(entity -> entity instanceof LivingEntity)
                .filter(entity -> entity.getType() != org.bukkit.entity.EntityType.ARMOR_STAND)
                .filter(entity -> entity.getType() != org.bukkit.entity.EntityType.PLAYER ||
                        ((Player) entity).getGameMode() != GameMode.CREATIVE)
                .map(entity -> (LivingEntity) entity)
                .map(this::createEntityData)
                .collect(Collectors.toList());
    }

    @Override
    public void setVelocity(UUID entityId, Vector3fc velocity) {
        Entity entity = server.getEntity(entityId);
        if (entity != null) {
            Vector newVelocity = new Vector(velocity.x(), velocity.y(), velocity.z());
            entity.setVelocity(newVelocity);
        }
    }

    @Override
    public void addPotionEffect(UUID entityId, PotionEffect effect) {
        Entity entity = server.getEntity(entityId);
        if (entity != null) {
            // TODO: add potion effect
        }
    }

    @Override
    public void removePotionEffect(UUID entityId, PotionType type) {
        Entity entity = server.getEntity(entityId);
        if (entity != null) {
            // TODO: remove potion effect
        }
    }

    @Override
    public void teleport(UUID entityId, Location location) {
        Entity entity = server.getEntity(entityId);
        if (entity != null) {
            org.bukkit.Location newLocation = locationMapper.map(location);
            entity.teleport(newLocation);
        }
    }

    @Override
    public void spawnEntity(EntityType type, Location spawnLocation) {
        org.bukkit.entity.EntityType spigotEntityType = entityTypeMapper.map(type);
        org.bukkit.Location spigotSpawnLocation = locationMapper.map(spawnLocation);
        spigotSpawnLocation.getWorld().spawnEntity(spigotSpawnLocation, spigotEntityType);
    }
}
