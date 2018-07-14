package gg.warcraft.monolith.spigot.event;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.core.EventService;
import gg.warcraft.monolith.api.entity.event.EntityDeathEvent;
import gg.warcraft.monolith.api.entity.event.EntityPreDeathEvent;
import gg.warcraft.monolith.api.entity.player.Player;
import gg.warcraft.monolith.api.item.Item;
import gg.warcraft.monolith.app.entity.event.SimpleEntityDeathEvent;
import gg.warcraft.monolith.app.entity.event.SimpleEntityPreDeathEvent;
import gg.warcraft.monolith.spigot.item.SpigotItemMapper;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class SpigotEntityEventMapper implements Listener {
    private final EventService eventService;
    private final SpigotItemMapper itemMapper;

    @Inject
    public SpigotEntityEventMapper(EventService eventService, SpigotItemMapper itemMapper) {
        this.eventService = eventService;
        this.itemMapper = itemMapper;
    }

    @EventHandler
    public void onEntityDamageEvent(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            return;
        }

        if (event.getEntity() instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity) event.getEntity();
            if (event.getDamage() > livingEntity.getHealth()) {
                EntityPreDeathEvent entityPreDeathEvent =
                        new SimpleEntityPreDeathEvent(livingEntity.getUniqueId(), false);
                eventService.publish(entityPreDeathEvent);

                if (entityPreDeathEvent.isCancelled() && !entityPreDeathEvent.isExplicitlyAllowed()) {
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
        // TODO wrap up implementation
        event.getDrops().clear();
//        event.getDrops().addAll(spigotDrops);
    }
}
