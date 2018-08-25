package gg.warcraft.monolith.spigot.event;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.core.EventService;
import gg.warcraft.monolith.api.menu.Button;
import gg.warcraft.monolith.api.menu.Click;
import gg.warcraft.monolith.api.menu.Menu;
import gg.warcraft.monolith.api.menu.service.MenuQueryService;
import gg.warcraft.monolith.api.menu.service.MenuRepository;
import gg.warcraft.monolith.app.menu.SimpleClick;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

import java.util.UUID;

public class SpigotInventoryEventMapper implements Listener {
    private final EventService eventService;
    private final MenuQueryService menuQueryService;
    private final MenuRepository menuRepository;

    @Inject
    public SpigotInventoryEventMapper(EventService eventService, MenuQueryService menuQueryService,
                                      MenuRepository menuRepository) {
        this.eventService = eventService;
        this.menuQueryService = menuQueryService;
        this.menuRepository = menuRepository;
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onInventoryClickEvent(InventoryClickEvent event) {
        UUID clickerId = event.getWhoClicked().getUniqueId();
        Menu menu = menuQueryService.getMenu(clickerId);
        if (menu != null) {
            event.setCancelled(true);
            if (event.isLeftClick() || event.isRightClick()) {
                Button button = menu.getButtons().get(event.getSlot());
                if (button != null) {
                    Click click = new SimpleClick(clickerId, event.isLeftClick(), event.isShiftClick());
                    button.getAction().accept(click);
                }
                // TODO publish Monolith menu click event
            }
        } else {
            // TODO publish Monolith inventory pre click event
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onInventoryCloseEvent(InventoryCloseEvent event) {
        UUID clickerId = event.getPlayer().getUniqueId();
        Menu menu = menuQueryService.getMenu(clickerId);
        if (menu != null) {
            menuRepository.delete(clickerId);
            // TODO publish Monolith menu click event
        } else {
            // TODO publish Monolith inventory close event
        }
    }
}
