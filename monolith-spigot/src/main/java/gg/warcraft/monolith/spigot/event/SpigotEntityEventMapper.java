package gg.warcraft.monolith.spigot.event;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.core.EventService;
import gg.warcraft.monolith.api.entity.event.EntityDeathEvent;
import gg.warcraft.monolith.api.item.ItemType;
import gg.warcraft.monolith.app.entity.event.SimpleEntityDeathEvent;
import gg.warcraft.monolith.spigot.item.SpigotItemTypeMapper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class SpigotEntityEventMapper implements Listener {
    private final EventService eventService;
    private final SpigotItemTypeMapper itemTypeMapper;

    @Inject
    public SpigotEntityEventMapper(EventService eventService, SpigotItemTypeMapper itemTypeMapper) {
        this.eventService = eventService;
        this.itemTypeMapper = itemTypeMapper;
    }

    @EventHandler
    public void onEntityDeath(org.bukkit.event.entity.EntityDeathEvent event) {
        UUID entityId = event.getEntity().getUniqueId();
        List<ItemType> drops = event.getDrops().stream()
                .map(itemStack -> itemTypeMapper.map(itemStack.getType(), itemStack.getData().getData()))
                .collect(Collectors.toList());
        EntityDeathEvent entityDeathEvent = new SimpleEntityDeathEvent(entityId, drops);
        eventService.publish(entityDeathEvent);

        // Give back the drops that we want to send back to Spigot
        List<ItemStack> spigotDrops = entityDeathEvent.getDrops().stream()
                .map(itemTypeMapper::map)
                .map(drop -> new ItemStack(drop.getMaterial(), 1, (short) 0, drop.getData()))
                .collect(Collectors.toList());
        event.getDrops().clear();
        event.getDrops().addAll(spigotDrops);
    }
}
