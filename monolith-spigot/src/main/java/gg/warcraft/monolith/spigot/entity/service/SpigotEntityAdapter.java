package gg.warcraft.monolith.spigot.entity.service;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.entity.EntityServerData;
import gg.warcraft.monolith.api.entity.EntityType;
import gg.warcraft.monolith.api.entity.service.EntityServerAdapter;
import gg.warcraft.monolith.api.world.Location;
import gg.warcraft.monolith.api.world.PotionEffect;
import gg.warcraft.monolith.api.world.PotionType;
import gg.warcraft.monolith.spigot.entity.SpigotEntityDataFactory;
import gg.warcraft.monolith.spigot.entity.SpigotEntityTypeMapper;
import gg.warcraft.monolith.spigot.world.SpigotLocationMapper;
import org.bukkit.GameMode;
import org.bukkit.Server;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.joml.Vector3fc;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class SpigotEntityAdapter implements EntityServerAdapter {
    private final Server server;
    private final SpigotEntityTypeMapper entityTypeMapper;
    private final SpigotLocationMapper locationMapper;
    private final SpigotEntityDataFactory entityDataFactory;

    @Inject
    public SpigotEntityAdapter(Server server, SpigotEntityTypeMapper entityTypeMapper,
                               SpigotLocationMapper locationMapper, SpigotEntityDataFactory entityDataFactory) {
        this.server = server;
        this.entityTypeMapper = entityTypeMapper;
        this.locationMapper = locationMapper;
        this.entityDataFactory = entityDataFactory;
    }

    EntityServerData createEntityServerData(LivingEntity entity) {
        return entityDataFactory.create(entity);
    }

    @Override
    public EntityServerData getEntityServerData(UUID entityId) {
        Entity entity = server.getEntity(entityId);
        if (entity instanceof LivingEntity) {
            return createEntityServerData((LivingEntity) entity);
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
                .map(this::createEntityServerData)
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
            // TODO: implement
            throw new IllegalStateException("Failed to add potion effect: method not implemented.");
        }
    }

    @Override
    public void removePotionEffect(UUID entityId, PotionType type) {
        Entity entity = server.getEntity(entityId);
        if (entity != null) {
            // TODO: implement
            throw new IllegalStateException("Failed to remove potion effect: method not implemented.");
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