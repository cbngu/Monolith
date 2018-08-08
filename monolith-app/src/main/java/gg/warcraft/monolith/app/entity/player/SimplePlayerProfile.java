package gg.warcraft.monolith.app.entity.player;

import gg.warcraft.monolith.api.entity.Team;
import gg.warcraft.monolith.api.entity.player.PlayerProfile;
import gg.warcraft.monolith.api.entity.player.PlayerProfileCopyer;
import gg.warcraft.monolith.app.entity.SimpleEntityProfile;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SimplePlayerProfile extends SimpleEntityProfile implements PlayerProfile {
    private final UUID playerId;
    private final long timeConnected;
    private final long timeFirstConnected;
    private final long timeLastSeen;
    private final long timePlayed;
    private final Map<String, Integer> currencies;
    private final Map<String, Integer> lifetimeCurrencies;
    private final Map<String, String> data;

    public SimplePlayerProfile(UUID playerId, long timeConnected, long timeFirstConnected, long timeLastSeen,
                               long timePlayed, Map<String, Integer> currencies,
                               Map<String, Integer> lifetimeCurrencies, Map<String, String> data, Team team) {
        super(playerId, team);
        this.playerId = playerId;
        this.timeConnected = timeConnected;
        this.timeFirstConnected = timeFirstConnected;
        this.timeLastSeen = timeLastSeen;
        this.timePlayed = timePlayed;
        this.currencies = currencies;
        this.lifetimeCurrencies = lifetimeCurrencies;
        this.data = data;
    }

    @Override
    public UUID getPlayerId() {
        return playerId;
    }

    @Override
    public long getTimeConnected() {
        return timeConnected;
    }

    @Override
    public long getTimeFirstConnected() {
        return timeFirstConnected;
    }

    @Override
    public long getTimeLastSeen() {
        return timeLastSeen;
    }

    @Override
    public long getTimePlayed() {
        return timePlayed;
    }

    @Override
    public Map<String, Integer> getCurrencies() {
        return new HashMap<>(currencies);
    }

    @Override
    public Map<String, Integer> getLifetimeCurrencies() {
        return new HashMap<>(lifetimeCurrencies);
    }

    @Override
    public Map<String, String> getData() {
        return data;
    }

    @Override
    public PlayerProfileCopyer getCopyer() {
        return new SimplePlayerProfileCopyer(playerId, timeConnected, timeFirstConnected, timeLastSeen, timePlayed,
                currencies, lifetimeCurrencies, data, getTeam());
    }
}
