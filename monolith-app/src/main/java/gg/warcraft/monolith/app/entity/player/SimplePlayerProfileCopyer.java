package gg.warcraft.monolith.app.entity.player;

import gg.warcraft.monolith.api.entity.Team;
import gg.warcraft.monolith.api.entity.player.PlayerProfile;
import gg.warcraft.monolith.api.entity.player.PlayerProfileCopyer;

import java.util.Map;
import java.util.UUID;

public class SimplePlayerProfileCopyer implements PlayerProfileCopyer {
    private final UUID playerId;
    private final long timeFirstConnected;
    private final Map<String, Integer> currencies;
    private final Map<String, Integer> lifetimeCurrencies;

    private long timeConnected;
    private long timeLastSeen;
    private long timePlayed;
    private Team team;

    public SimplePlayerProfileCopyer(UUID playerId, long timeConnected, long timeFirstConnected, long timeLastSeen,
                                     long timePlayed, Map<String, Integer> currencies,
                                     Map<String, Integer> lifetimeCurrencies, Team team) {
        this.playerId = playerId;
        this.timeConnected = timeConnected;
        this.timeFirstConnected = timeFirstConnected;
        this.timeLastSeen = timeLastSeen;
        this.timePlayed = timePlayed;
        this.currencies = currencies;
        this.lifetimeCurrencies = lifetimeCurrencies;
        this.team = team;
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
    public PlayerProfileCopyer withTeam(Team team) {
        this.team = team;
        return this;
    }

    @Override
    public PlayerProfile copy() {
        return new SimplePlayerProfile(playerId, timeConnected, timeFirstConnected, timeLastSeen, timePlayed,
                currencies, lifetimeCurrencies, team);
    }
}
