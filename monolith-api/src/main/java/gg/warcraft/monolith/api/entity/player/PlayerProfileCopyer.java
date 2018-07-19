package gg.warcraft.monolith.api.entity.player;

import gg.warcraft.monolith.api.entity.Team;

import java.util.Map;

public interface PlayerProfileCopyer {

    PlayerProfileCopyer withTimeConnected(long timeConnected);

    PlayerProfileCopyer withTimeLastSeen(long timeLastSeen);

    PlayerProfileCopyer withTimePlayed(long timePlayed);

    PlayerProfileCopyer withCurrencies(Map<String, Integer> currencies);

    PlayerProfileCopyer withCurrenciesTotal(Map<String, Integer> currenciesTotal);

    PlayerProfileCopyer withTeam(Team team);

    PlayerProfile copy();
}
