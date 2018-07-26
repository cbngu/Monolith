package gg.warcraft.monolith.spigot.event;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.core.EventService;
import gg.warcraft.monolith.api.entity.event.EntityDeathEvent;
import gg.warcraft.monolith.api.entity.event.EntityInteractEvent;
import gg.warcraft.monolith.api.entity.event.EntityPreFatalDamageEvent;
import gg.warcraft.monolith.api.entity.event.EntityPreInteractEvent;
import gg.warcraft.monolith.api.entity.player.Player;
import gg.warcraft.monolith.api.item.Item;
import gg.warcraft.monolith.api.world.Location;
import gg.warcraft.monolith.app.entity.event.SimpleEntityDeathEvent;
import gg.warcraft.monolith.app.entity.event.SimpleEntityInteractEvent;
import gg.warcraft.monolith.app.entity.event.SimpleEntityPreFatalDamageEvent;
import gg.warcraft.monolith.app.entity.event.SimpleEntityPreInteractEvent;
import gg.warcraft.monolith.spigot.item.SpigotItemMapper;
import gg.warcraft.monolith.spigot.world.SpigotLocationMapper;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.EquipmentSlot;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class SpigotEntityEventMapper implements Listener {
    private final EventService eventService;
    private final SpigotItemMapper itemMapper;
    private final SpigotLocationMapper locationMapper;

    @Inject
    public SpigotEntityEventMapper(EventService eventService, SpigotItemMapper itemMapper,
                                   SpigotLocationMapper locationMapper) {
        this.eventService = eventService;
        this.itemMapper = itemMapper;
        this.locationMapper = locationMapper;
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onEntityPreInteractEvent(PlayerInteractAtEntityEvent event) {
        org.bukkit.entity.Player player = event.getPlayer();
        UUID entityId = event.getRightClicked().getUniqueId();
        UUID playerId = player.getUniqueId();
        Item itemInClickHand = event.getHand() == EquipmentSlot.HAND
                ? itemMapper.map(player.getEquipment().getItemInMainHand())
                : itemMapper.map(player.getEquipment().getItemInOffHand());
        Location interactLocation = locationMapper.map(event.getClickedPosition().toLocation(player.getWorld()));
        EntityPreInteractEvent entityPreInteractEvent =
                new SimpleEntityPreInteractEvent(entityId, playerId, itemInClickHand, interactLocation, false);
        eventService.publish(entityPreInteractEvent);

        if (entityPreInteractEvent.isExplicitlyAllowed()) {
            event.setCancelled(false);
        } else if (entityPreInteractEvent.isCancelled()) {
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onEntityInteractEvent(PlayerInteractAtEntityEvent event) {
        if (event.isCancelled()) {
            return;
        }

        org.bukkit.entity.Player player = event.getPlayer();
        UUID entityId = event.getRightClicked().getUniqueId(); // FIXME do we only want this for livingentities? Gonna need a new event for others
        UUID playerId = player.getUniqueId();
        Item itemInClickHand = event.getHand() == EquipmentSlot.HAND
                ? itemMapper.map(player.getEquipment().getItemInMainHand())
                : itemMapper.map(player.getEquipment().getItemInOffHand());
        Location interactLocation = locationMapper.map(event.getClickedPosition().toLocation(player.getWorld()));
        EntityInteractEvent entityInteractEvent =
                new SimpleEntityInteractEvent(entityId, playerId, itemInClickHand, interactLocation);
        eventService.publish(entityInteractEvent);
    }

    // TODO rework this into multiple events: EntityDamageEvent, Entity(pre)FatalDamageEvent, and EntityDeathEvent
    @EventHandler
    public void onEntityDamageEvent(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            return;
        }

        if (event.getEntity() instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity) event.getEntity();
            if (event.getDamage() > livingEntity.getHealth()) {
                EntityPreFatalDamageEvent entityPreFatalDamageEvent =
                        new SimpleEntityPreFatalDamageEvent(livingEntity.getUniqueId(), false);
                eventService.publish(entityPreFatalDamageEvent);

                if (entityPreFatalDamageEvent.isCancelled() && !entityPreFatalDamageEvent.isExplicitlyAllowed()) {
                    event.setDamage(livingEntity.getHealth() - 1);
                }
            }
        }
    }

    @EventHandler
    public void onEntityDeath(org.bukkit.event.entity.EntityDeathEvent event) {
        if (event.getEntity() instanceof Player) {
            return;
        }

        UUID entityId = event.getEntity().getUniqueId();
        List<Item> drops = event.getDrops().stream()
                .map(itemMapper::map)
                .collect(Collectors.toList());
        EntityDeathEvent entityDeathEvent = new SimpleEntityDeathEvent(entityId, drops);
        eventService.publish(entityDeathEvent);

//        List<ItemStack> spigotDrops = entityDeathEvent.getDrops().stream()
//                .map(itemMapper::map)
//                .collect(Collectors.toList());
        // TODO wrap up implementation, give EntityPreDeathEvent alternativeDrops like block event?
        event.getDrops().clear();
//        event.getDrops().addAll(spigotDrops);
    }
}
