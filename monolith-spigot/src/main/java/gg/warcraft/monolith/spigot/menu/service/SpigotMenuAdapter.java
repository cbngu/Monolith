package gg.warcraft.monolith.spigot.menu.service;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.core.TaskService;
import gg.warcraft.monolith.api.menu.Menu;
import gg.warcraft.monolith.api.menu.service.MenuServerAdapter;
import gg.warcraft.monolith.spigot.menu.SpigotMenuMapper;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.UUID;

public class SpigotMenuAdapter implements MenuServerAdapter {
    private final Server server;
    private final SpigotMenuMapper menuMapper;
    private final TaskService taskService;

    @Inject
    public SpigotMenuAdapter(Server server, SpigotMenuMapper menuMapper, TaskService taskService) {
        this.server = server;
        this.menuMapper = menuMapper;
        this.taskService = taskService;
    }

    @Override
    public void showMenu(Menu menu, UUID viewerId) {
        Inventory inventory = menuMapper.map(menu, viewerId);
        Player player = server.getPlayer(viewerId);
        taskService.runNextTick(() -> player.openInventory(inventory));
    }

    @Override
    public void closeMenu(UUID viewerId) {
        Player player = server.getPlayer(viewerId);
        taskService.runNextTick(player::closeInventory);
    }
}
