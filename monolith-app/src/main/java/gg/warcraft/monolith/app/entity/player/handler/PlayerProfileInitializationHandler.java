package gg.warcraft.monolith.app.entity.player.handler;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import gg.warcraft.monolith.api.entity.player.PlayerProfile;
import gg.warcraft.monolith.api.entity.player.event.PlayerPreConnectEvent;
import gg.warcraft.monolith.api.entity.player.service.PlayerProfileRepository;
import gg.warcraft.monolith.app.entity.player.SimplePlayerProfile;

import java.util.HashMap;
import java.util.UUID;

public class PlayerProfileInitializationHandler {
    private final PlayerProfileRepository playerProfileRepository;

    @Inject
    public PlayerProfileInitializationHandler(PlayerProfileRepository playerProfileRepository) {
        this.playerProfileRepository = playerProfileRepository;
    }

    @Subscribe
    public void onPlayerPreConnect(PlayerPreConnectEvent event) {
        UUID playerId = event.getPlayerId();
        long now = System.currentTimeMillis();
        PlayerProfile profile = playerProfileRepository.get(playerId);
        if (profile == null) {
            PlayerProfile newProfile = new SimplePlayerProfile(playerId, now, now, now, 0, new HashMap<>(),
                    new HashMap<>(), new HashMap<>(), new HashMap<>());
            playerProfileRepository.save(newProfile);
        } else {
            PlayerProfile newProfile = profile.getCopyer()
                    .withTimeConnected(now)
                    .withTimeLastSeen(now)
                    .copy();
            playerProfileRepository.save(newProfile);
        }
    }
}
