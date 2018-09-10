package gg.warcraft.monolith.spigot.menu;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class MonolithMenuHolder implements InventoryHolder {
    private final Player player;

    public MonolithMenuHolder(Player player) {
        this.player = player;
    }

    @Override
    public Inventory getInventory() {
        if (player != null) {
            return player.getInventory();
        }
        return null;
    }
}
