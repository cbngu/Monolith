package gg.warcraft.monolith.spigot.entity.player.service;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.entity.player.PlayerServerData;
import gg.warcraft.monolith.api.entity.player.service.PlayerServerAdapter;
import gg.warcraft.monolith.api.item.Item;
import gg.warcraft.monolith.spigot.entity.player.SpigotOfflinePlayerData;
import gg.warcraft.monolith.spigot.entity.player.SpigotPlayerDataFactory;
import gg.warcraft.monolith.spigot.item.SpigotItemMapper;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class SpigotPlayerAdapter implements PlayerServerAdapter {
    private final Server server;
    private final SpigotPlayerDataFactory playerDataFactory;
    private final SpigotItemMapper itemMapper;

    @Inject
    public SpigotPlayerAdapter(Server server, SpigotPlayerDataFactory playerDataFactory,
                               SpigotItemMapper itemMapper) {
        this.server = server;
        this.playerDataFactory = playerDataFactory;
        this.itemMapper = itemMapper;
    }

    @Override
    public PlayerServerData getPlayerServerData(UUID playerId) {
        Player player = server.getPlayer(playerId);
        if (player != null) {
            return playerDataFactory.create(player);
        }

        OfflinePlayer offlinePlayer = server.getOfflinePlayer(playerId);
        if (offlinePlayer != null) {
            return new SpigotOfflinePlayerData(offlinePlayer);
        }

        return null;
    }

    @Override
    public Collection<UUID> getOnlinePlayers() {
        return server.getOnlinePlayers().stream()
                .map(Player::getUniqueId)
                .collect(Collectors.toList());
    }

    @Override
    public boolean giveItem(UUID playerId, Item item, boolean dropOnFullInventory) {
        Player player = server.getPlayer(playerId);
        if (player == null) {
            return false;
        }

        ItemStack spigotItem = itemMapper.map(item);
        Map<Integer, ItemStack> undelivered = player.getInventory().addItem(spigotItem);
        if (undelivered.isEmpty()) {
            return true;
        } else if (dropOnFullInventory) {
            undelivered.values().forEach(undeliveredItem -> {
                Location playerLocation = player.getLocation();
                playerLocation.getWorld().dropItemNaturally(playerLocation, undeliveredItem);
            });
        }

        return false;
    }

    @Override
    public UUID resolvePlayerId(String minecraftName) {
        Player player = server.getPlayerExact(minecraftName);
        return player != null ? player.getUniqueId() : null;
    }

    @Override
    public void sendMessage(UUID playerId, String message) {
        Player player = server.getPlayer(playerId);
        if (player != null) {
            player.sendMessage(message);
        }
    }

    @Override
    public void sendTitle(UUID playerId, String title, String subTitle) {
        Player player = server.getPlayer(playerId);
        if (player != null) {
            player.sendTitle(title, subTitle);
        }
    }
}
