package gg.warcraft.monolith.app.entity.player;

import gg.warcraft.monolith.api.entity.player.PlayerProfile;
import gg.warcraft.monolith.api.entity.player.PlayerProfileCopyer;

import java.util.Map;
import java.util.UUID;

public class SimplePlayerProfileCopyer implements PlayerProfileCopyer {
    private final UUID playerId;
    private final long timeFirstConnected;
    private final Map<String, Integer> currencies;
    private final Map<String, Integer> lifetimeCurrencies;
    private final Map<String, String> data;

    private long timeConnected;
    private long timeLastSeen;
    private long timePlayed;

    public SimplePlayerProfileCopyer(UUID playerId, long timeConnected, long timeFirstConnected, long timeLastSeen,
                                     long timePlayed, Map<String, Integer> currencies,
                                     Map<String, Integer> lifetimeCurrencies, Map<String, String> data) {
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
    public PlayerProfileCopyer withTimeConnected(long timeConnected) {
        this.timeConnected = timeConnected;
        return this;
    }

    @Override
    public PlayerProfileCopyer withTimeLastSeen(long timeLastSeen) {
        this.timeLastSeen = timeLastSeen;
        return this;
    }

    @Override
    public PlayerProfileCopyer withTimePlayed(long timePlayed) {
        this.timePlayed = timePlayed;
        return this;
    }

    @Override
    public PlayerProfileCopyer withCurrencies(Map<String, Integer> currencies) {
        this.currencies.clear();
        this.currencies.putAll(currencies);
        return this;
    }

    @Override
    public PlayerProfileCopyer withLifetimeCurrencies(Map<String, Integer> currenciesTotal) {
        this.lifetimeCurrencies.clear();
        this.lifetimeCurrencies.putAll(currenciesTotal);
        return this;
    }

    @Override
    public PlayerProfileCopyer withData(Map<String, String> data) {
        this.data.clear();
        this.data.putAll(data);
        return this;
    }

    @Override
    public PlayerProfile copy() {
        return new SimplePlayerProfile(playerId, timeConnected, timeFirstConnected, timeLastSeen, timePlayed,
                currencies, lifetimeCurrencies, data);
    }
}
