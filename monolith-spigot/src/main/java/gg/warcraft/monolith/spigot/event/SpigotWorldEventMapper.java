package gg.warcraft.monolith.spigot.event;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.core.EventService;
import gg.warcraft.monolith.api.item.Item;
import gg.warcraft.monolith.api.world.BlockLocation;
import gg.warcraft.monolith.api.world.Location;
import gg.warcraft.monolith.api.world.block.Block;
import gg.warcraft.monolith.api.world.block.BlockFace;
import gg.warcraft.monolith.api.world.block.event.BlockBreakEvent;
import gg.warcraft.monolith.api.world.block.event.BlockInteractEvent;
import gg.warcraft.monolith.api.world.block.event.BlockInteraction;
import gg.warcraft.monolith.api.world.block.event.BlockPlaceEvent;
import gg.warcraft.monolith.api.world.block.event.BlockPreBreakEvent;
import gg.warcraft.monolith.api.world.block.event.BlockPrePlaceEvent;
import gg.warcraft.monolith.api.world.service.WorldCommandService;
import gg.warcraft.monolith.api.world.service.WorldQueryService;
import gg.warcraft.monolith.app.world.block.event.SimpleBlockBreakEvent;
import gg.warcraft.monolith.app.world.block.event.SimpleBlockInteractEvent;
import gg.warcraft.monolith.app.world.block.event.SimpleBlockPlaceEvent;
import gg.warcraft.monolith.app.world.block.event.SimpleBlockPreBreakEvent;
import gg.warcraft.monolith.app.world.block.event.SimpleBlockPrePlaceEvent;
import gg.warcraft.monolith.spigot.item.SpigotItemMapper;
import gg.warcraft.monolith.spigot.world.SpigotBlockFaceMapper;
import gg.warcraft.monolith.spigot.world.SpigotBlockMapper;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class SpigotWorldEventMapper implements Listener {
    private final EventService eventService;
    private final SpigotBlockMapper blockMapper;
    private final SpigotBlockFaceMapper blockFaceMapper;
    private final SpigotItemMapper itemMapper;
    private final WorldQueryService worldQueryService;
    private final WorldCommandService worldCommandService;

    private final Map<Event, List<Item>> alternativeDropsByEvent;

    @Inject
    public SpigotWorldEventMapper(EventService eventService, SpigotBlockMapper blockMapper,
                                  SpigotBlockFaceMapper blockFaceMapper, SpigotItemMapper itemMapper,
                                  WorldQueryService worldQueryService, WorldCommandService worldCommandService) {
        this.eventService = eventService;
        this.blockMapper = blockMapper;
        this.blockFaceMapper = blockFaceMapper;
        this.itemMapper = itemMapper;
        this.worldQueryService = worldQueryService;
        this.worldCommandService = worldCommandService;
        this.alternativeDropsByEvent = new HashMap<>();
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onBlockPreBreakEvent(org.bukkit.event.block.BlockBreakEvent event) {
        Block block = blockMapper.map(event.getBlock());
        List<Item> alternativeDrops = event.isDropItems() ? null : new ArrayList<>();
        UUID playerId = event.getPlayer().getUniqueId();
        boolean cancelled = event.isCancelled();
        BlockPreBreakEvent blockPreBreakEvent = new SimpleBlockPreBreakEvent(block, alternativeDrops, playerId, cancelled);
        eventService.publish(blockPreBreakEvent);

        if (blockPreBreakEvent.isExplicitlyAllowed()) {
            event.setCancelled(false);
        } else {
            event.setCancelled(blockPreBreakEvent.isCancelled());
        }
        List<Item> actualAlternativeDrops = blockPreBreakEvent.getAlternativeDrops();
        if (actualAlternativeDrops == null) {
            event.setDropItems(true);
        } else {
            event.setDropItems(false);
            if (!actualAlternativeDrops.isEmpty()) {
                alternativeDropsByEvent.put(event, actualAlternativeDrops);
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onBlockBreakEvent(org.bukkit.event.block.BlockBreakEvent event) {
        List<Item> alternativeDrops = alternativeDropsByEvent.remove(event);
        if (event.isCancelled()) {
            return;
        }

        Block block = blockMapper.map(event.getBlock());
        UUID playerId = event.getPlayer().getUniqueId();
        BlockBreakEvent blockBreakEvent = new SimpleBlockBreakEvent(block, alternativeDrops, playerId);
        eventService.publish(blockBreakEvent);

        if (alternativeDrops != null && !alternativeDrops.isEmpty()) {
            BlockLocation blockLocation = block.getLocation();
            Location dropLocation = worldQueryService.getLocation(blockLocation.getWorld().getType(),
                    blockLocation.getX() + 0.5f, blockLocation.getY() + 0.5f, blockLocation.getZ() + 0.5f);
            worldCommandService.dropItemsAt(alternativeDrops, dropLocation);
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onBlockPrePlaceEvent(org.bukkit.event.block.BlockPlaceEvent event) {
        Block block = blockMapper.map(event.getBlock());
        Block placedBlock = blockMapper.map(event.getBlockPlaced());
        Block placedAgainst = blockMapper.map(event.getBlockAgainst());
        UUID playerId = event.getPlayer().getUniqueId();
        boolean cancelled = event.isCancelled();
        BlockPrePlaceEvent blockPrePlaceEvent =
                new SimpleBlockPrePlaceEvent(block, placedBlock, placedAgainst, playerId, cancelled);
        eventService.publish(blockPrePlaceEvent);

        if (blockPrePlaceEvent.isExplicitlyAllowed()) {
            event.setCancelled(false);
        } else {
            event.setCancelled(blockPrePlaceEvent.isCancelled());
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onBlockPlaceEvent(org.bukkit.event.block.BlockPlaceEvent event) {
        if (event.isCancelled()) {
            return;
        }

        Block block = blockMapper.map(event.getBlock());
        Block placedBlock = blockMapper.map(event.getBlockPlaced());
        Block placedAgainst = blockMapper.map(event.getBlockAgainst());
        UUID playerId = event.getPlayer().getUniqueId();
        BlockPlaceEvent blockPlaceEvent = new SimpleBlockPlaceEvent(block, placedBlock, placedAgainst, playerId);
        eventService.publish(blockPlaceEvent);
    }

    void onBlockInteractEvent(PlayerInteractEvent event) {
        if (event.isCancelled()) {
            return;
        }

        Block block = blockMapper.map(event.getClickedBlock());
        BlockFace clickedFace = blockFaceMapper.map(event.getBlockFace());
        BlockInteraction interaction = BlockInteraction.valueOf(event.getAction().name());
        Item itemInClickHand = itemMapper.map(event.getItem());
        UUID playerId = event.getPlayer().getUniqueId();
        BlockInteractEvent blockInteractEvent = new SimpleBlockInteractEvent(block, interaction, clickedFace,
                itemInClickHand, playerId);
        eventService.publish(blockInteractEvent);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerInteractEvent(PlayerInteractEvent event) {
        switch (event.getAction()) {
            case LEFT_CLICK_BLOCK:
            case RIGHT_CLICK_BLOCK:
            case LEFT_CLICK_AIR: // TODO this enum needs work,
            case RIGHT_CLICK_AIR:
                if (!event.hasBlock()) {
                    // ignore block break and place events
                    onBlockInteractEvent(event);
                }
                break;
            case PHYSICAL:
                // TODO: implement BlockTriggerEvent
                break;
        }
    }
}
