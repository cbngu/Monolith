package gg.warcraft.monolith.app.entity.player.persistence;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import gg.warcraft.monolith.api.entity.Team;

import java.util.Map;
import java.util.UUID;

public class PlayerProfileItem {
    private final UUID playerId;
    private final long timeConnected;
    private final long timeFirstConnected;
    private final long timeLastSeen;
    private final long timePlayed;
    private final Map<String, Integer> currencies;
    private final Map<String, Integer> currenciesTotal;
    private final Team team;

    @JsonCreator
    public PlayerProfileItem(@JsonProperty("playerId") UUID playerId,
                             @JsonProperty("timeConnected") long timeConnected,
                             @JsonProperty("timeFirstConnected") long timeFirstConnected,
                             @JsonProperty("timeLastSeen") long timeLastSeen,
                             @JsonProperty("timePlayed") long timePlayed,
                             @JsonProperty("currencies") Map<String, Integer> currencies,
                             @JsonProperty("currenciesTotal") Map<String, Integer> currenciesTotal,
                             @JsonProperty("team") Team team) {
        this.playerId = playerId;
        this.timeConnected = timeConnected;
        this.timeFirstConnected = timeFirstConnected;
        this.timeLastSeen = timeLastSeen;
        this.timePlayed = timePlayed;
        this.currencies = currencies;
        this.currenciesTotal = currenciesTotal;
        this.team = team;
    }

    public UUID getPlayerId() {
        return playerId;
    }

    public long getTimeConnected() {
        return timeConnected;
    }

    public long getTimeFirstConnected() {
        return timeFirstConnected;
    }

    public long getTimeLastSeen() {
        return timeLastSeen;
    }

    public long getTimePlayed() {
        return timePlayed;
    }

    public Map<String, Integer> getCurrencies() {
        return currencies;
    }

    public Map<String, Integer> getCurrenciesTotal() {
        return currenciesTotal;
    }

    public Team getTeam() {
        return team;
    }
}
