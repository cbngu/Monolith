package gg.warcraft.monolith.spigot.event;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.combat.event.ProjectileHitEvent;
import gg.warcraft.monolith.api.combat.event.ProjectileLaunchEvent;
import gg.warcraft.monolith.api.combat.event.ProjectilePreHitEvent;
import gg.warcraft.monolith.api.combat.event.ProjectilePreLaunchEvent;
import gg.warcraft.monolith.api.core.EventService;
import gg.warcraft.monolith.api.world.block.Block;
import gg.warcraft.monolith.app.combat.event.SimpleProjectileHitEvent;
import gg.warcraft.monolith.app.combat.event.SimpleProjectileLaunchEvent;
import gg.warcraft.monolith.app.combat.event.SimpleProjectilePreHitEvent;
import gg.warcraft.monolith.app.combat.event.SimpleProjectilePreLaunchEvent;
import gg.warcraft.monolith.spigot.world.SpigotBlockMapper;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.projectiles.ProjectileSource;

import java.util.UUID;

public class SpigotProjectileEventMapper implements Listener {
    private final EventService eventService;
    private final SpigotBlockMapper blockMapper;

    @Inject
    public SpigotProjectileEventMapper(EventService eventService, SpigotBlockMapper blockMapper) {
        this.eventService = eventService;
        this.blockMapper = blockMapper;
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onProjectileLaunchEvent(org.bukkit.event.entity.ProjectileLaunchEvent event) {
        org.bukkit.entity.Projectile projectile = event.getEntity();
        ProjectileSource shooter = projectile.getShooter();
        UUID shooterId = null;
        if (shooter instanceof Entity) {
            shooterId = ((Entity) shooter).getUniqueId();
        }

        ProjectilePreLaunchEvent preLaunchEvent =
                new SimpleProjectilePreLaunchEvent(projectile.getUniqueId(), shooterId, event.isCancelled());
        eventService.publish(preLaunchEvent);

        boolean isCancelled = preLaunchEvent.isCancelled() && !preLaunchEvent.isExplicitlyAllowed();
        event.setCancelled(isCancelled);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onProjectileLaunchEventMonitor(org.bukkit.event.entity.ProjectileLaunchEvent event) {
        org.bukkit.entity.Projectile projectile = event.getEntity();
        ProjectileSource shooter = projectile.getShooter();
        UUID shooterId = null;
        if (shooter instanceof Entity) {
            shooterId = ((Entity) shooter).getUniqueId();
        }

        ProjectileLaunchEvent preLaunchEvent = new SimpleProjectileLaunchEvent(projectile.getUniqueId(), shooterId);
        eventService.publish(preLaunchEvent);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onProjectileHitEvent(org.bukkit.event.entity.ProjectileHitEvent event) {
        org.bukkit.entity.Projectile projectile = event.getEntity();
        Block block = blockMapper.map(event.getHitBlock());
        UUID entityId = null;
        if (event.getHitEntity() != null) {
            entityId = event.getHitEntity().getUniqueId();
        }

        ProjectilePreHitEvent preHitEvent =
                new SimpleProjectilePreHitEvent(projectile.getUniqueId(), block, entityId, false);
        eventService.publish(preHitEvent);

        boolean isCancelled = preHitEvent.isCancelled() && !preHitEvent.isExplicitlyAllowed();
        event.getEntity().setBounce(isCancelled);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onProjectileHitEventMonitor(org.bukkit.event.entity.ProjectileHitEvent event) {
        org.bukkit.entity.Projectile projectile = event.getEntity();
        Block block = blockMapper.map(event.getHitBlock());
        UUID entityId = null;
        if (event.getHitEntity() != null) {
            entityId = event.getHitEntity().getUniqueId();
        }

        ProjectileHitEvent preHitEvent = new SimpleProjectileHitEvent(projectile.getUniqueId(), block, entityId);
        eventService.publish(preHitEvent);
    }
}
