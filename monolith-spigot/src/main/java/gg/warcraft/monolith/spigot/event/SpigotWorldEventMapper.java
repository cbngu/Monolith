package gg.warcraft.monolith.spigot.event;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.core.EventService;
import gg.warcraft.monolith.api.world.block.Block;
import gg.warcraft.monolith.api.world.event.BlockBreakEvent;
import gg.warcraft.monolith.spigot.item.SpigotItemTypeMapper;
import gg.warcraft.monolith.spigot.world.SpigotBlockMapper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class SpigotWorldEventMapper implements Listener {
    private final EventService eventService;
    private final SpigotBlockMapper blockMapper;
    private final SpigotItemTypeMapper itemTypeMapper;

    @Inject
    public SpigotWorldEventMapper(EventService eventService, SpigotBlockMapper blockMapper,
                                  SpigotItemTypeMapper itemTypeMapper) {
        this.eventService = eventService;
        this.blockMapper = blockMapper;
        this.itemTypeMapper = itemTypeMapper;
    }

    @EventHandler
    public void onBlockBreak(org.bukkit.event.block.BlockBreakEvent event) {
        Block block = blockMapper.map(event.getBlock());
        BlockBreakEvent blockBreakEvent = new SimpleBlockBreakEvent(block, event.isDropItems(), event.isCancelled());
        eventService.publish(blockBreakEvent);
        event.setCancelled(blockBreakEvent.isCancelled());
        event.setDropItems(blockBreakEvent.shouldDropItems());
    }
}
