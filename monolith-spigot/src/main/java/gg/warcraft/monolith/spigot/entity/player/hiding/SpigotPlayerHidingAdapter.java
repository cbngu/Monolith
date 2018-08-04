package gg.warcraft.monolith.spigot.entity.player.hiding;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.entity.player.hiding.PlayerHidingServerAdapter;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;
import java.util.UUID;

public class SpigotPlayerHidingAdapter implements PlayerHidingServerAdapter {
    private final Server server;
    private final Plugin plugin;

    @Inject
    public SpigotPlayerHidingAdapter(Server server, Plugin plugin) {
        this.server = server;
        this.plugin = plugin;
    }

    @Override
    public void hidePlayer(UUID playerId, UUID... from) {
        Player player = server.getPlayer(playerId);
        Arrays.stream(from).forEach(id -> server.getPlayer(id).hidePlayer(plugin, player));
    }

    @Override
    public void revealPlayer(UUID playerId, UUID... to) {
        Player player = server.getPlayer(playerId);
        Arrays.stream(to).forEach(id -> server.getPlayer(id).showPlayer(plugin, player));
    }
}
