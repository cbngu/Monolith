package gg.warcraft.monolith.app.entity.player.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import gg.warcraft.monolith.api.core.JsonMapper;
import gg.warcraft.monolith.api.core.PersistenceService;
import gg.warcraft.monolith.api.core.PluginLogger;
import gg.warcraft.monolith.api.entity.player.PlayerProfile;
import gg.warcraft.monolith.api.entity.player.service.PlayerProfileRepository;
import gg.warcraft.monolith.app.entity.player.SimplePlayerProfile;
import gg.warcraft.monolith.app.entity.player.persistence.PlayerProfileItem;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

@Singleton
public class DefaultPlayerProfileRepository implements PlayerProfileRepository {
    private static final String PROFILE_KEY_PREFIX = "playerprofile:";

    private final PersistenceService persistenceService;
    private final ObjectMapper jsonMapper;
    private final Logger pluginLogger;

    @Inject
    public DefaultPlayerProfileRepository(PersistenceService persistenceService, @JsonMapper ObjectMapper jsonMapper,
                                          @PluginLogger Logger pluginLogger) {
        this.persistenceService = persistenceService;
        this.jsonMapper = jsonMapper;
        this.pluginLogger = pluginLogger;
    }

    String createProfileKey(UUID playerId) {
        return PROFILE_KEY_PREFIX + playerId;
    }

    PlayerProfile mapItemToProfile(PlayerProfileItem item) {
        UUID playerId = item.getPlayerId();
        long timeConnected = item.getTimeConnected();
        long timeFirstConnected = item.getTimeFirstConnected();
        long timeLastSeen = item.getTimeLastSeen();
        long timePlayed = item.getTimePlayed();
        Map<String, Integer> currencies = item.getCurrencies();
        Map<String, Integer> lifetimeCurrencies = item.getLifetimeCurrencies();
        Map<String, String> data = item.getData();
        return new SimplePlayerProfile(playerId, timeConnected, timeFirstConnected, timeLastSeen, timePlayed,
                currencies, lifetimeCurrencies, data);
    }

    @Override
    public PlayerProfile get(UUID playerId) {
        String profileKey = createProfileKey(playerId);
        String profileJson = persistenceService.get(profileKey);
        if (profileJson == null) {
            pluginLogger.severe("Failed to retrieve profile for player " + playerId);
            return null;
        }

        try {
            PlayerProfileItem profileItem = jsonMapper.readValue(profileJson, PlayerProfileItem.class);
            return mapItemToProfile(profileItem);
        } catch (IOException ex) {
            pluginLogger.severe(ex.getMessage());
            return null;
        }
    }

    PlayerProfileItem mapProfileToItem(PlayerProfile profile) {
        UUID playerId = profile.getPlayerId();
        long timeConnected = profile.getTimeConnected();
        long timeFirstConnected = profile.getTimeFirstConnected();
        long timeLastSeen = profile.getTimeLastSeen();
        long timePlayed = profile.getTimePlayed();
        Map<String, Integer> currencies = profile.getCurrencies();
        Map<String, Integer> lifetimeCurrencies = profile.getLifetimeCurrencies();
        Map<String, String> data = profile.getData();
        return new PlayerProfileItem(playerId, timeConnected, timeFirstConnected, timeLastSeen, timePlayed, currencies,
                lifetimeCurrencies, data);
    }

    @Override
    public void save(PlayerProfile profile) {
        String profileKey = createProfileKey(profile.getPlayerId());
        PlayerProfileItem profileItem = mapProfileToItem(profile);
        try {
            String profileJson = jsonMapper.writeValueAsString(profileItem);
            persistenceService.set(profileKey, profileJson);
        } catch (IOException ex) {
            pluginLogger.severe(ex.getMessage());
        }
    }
}
