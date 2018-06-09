package gg.warcraft.monolith.spigot.entity.player.adapter;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.entity.player.service.PlayerServerAdapter;
import org.bukkit.Server;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

public class SpigotPlayerAdapter implements PlayerServerAdapter {
    private final Server server;

    @Inject
    public SpigotPlayerAdapter(Server server) {
        this.server = server;
    }

    @Override
    public Collection<UUID> getOnlinePlayers() {
        return server.getOnlinePlayers().stream()
                .map(Player::getUniqueId)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isNameAvailable(String name) {
        // TODO: integrate with display name
        return server.getPlayerExact(name) == null;
    }

    @Override
    public UUID resolvePlayerId(String minecraftName) {
        Player player = server.getPlayerExact(minecraftName);
        return player != null ? player.getUniqueId() : null;
    }
}
