package gg.warcraft.monolith.spigot.menu.service;

import com.google.inject.Inject;
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

    @Inject
    public SpigotMenuAdapter(Server server, SpigotMenuMapper menuMapper) {
        this.server = server;
        this.menuMapper = menuMapper;
    }

    @Override
    public void showMenu(Menu menu) {
        Inventory inventory = menuMapper.map(menu);
        Player player = server.getPlayer(menu.getViewerId());
        player.openInventory(inventory);
    }

    @Override
    public void closeMenu(UUID viewerId) {
        Player player = server.getPlayer(viewerId);
        player.closeInventory();
    }
}
