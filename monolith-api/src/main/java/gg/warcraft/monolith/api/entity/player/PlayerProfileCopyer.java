package gg.warcraft.monolith.api.entity.player;

import java.util.Map;

public interface PlayerProfileCopyer {

    PlayerProfileCopyer withTimeConnected(long timeConnected);

    PlayerProfileCopyer withTimeLastSeen(long timeLastSeen);

    PlayerProfileCopyer withTimePlayed(long timePlayed);

    PlayerProfileCopyer withCurrencies(Map<String, Integer> currencies);

    PlayerProfileCopyer withLifetimeCurrencies(Map<String, Integer> lifetimeCurrencies);

    PlayerProfileCopyer withTeam(String team);

    PlayerProfileCopyer withData(Map<String, String> data);

    PlayerProfile copy();
}
