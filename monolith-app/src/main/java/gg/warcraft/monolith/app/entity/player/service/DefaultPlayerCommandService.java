package gg.warcraft.monolith.app.entity.player.service;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.entity.player.Currency;
import gg.warcraft.monolith.api.entity.player.PlayerProfile;
import gg.warcraft.monolith.api.entity.player.service.PlayerCommandService;
import gg.warcraft.monolith.api.entity.player.service.PlayerProfileRepository;
import gg.warcraft.monolith.api.entity.player.service.PlayerServerAdapter;
import gg.warcraft.monolith.api.util.ColorCode;

import java.util.Map;
import java.util.UUID;

public class DefaultPlayerCommandService implements PlayerCommandService {
    private final PlayerProfileRepository playerProfileRepository;
    private final PlayerServerAdapter playerServerAdapter;

    @Inject
    public DefaultPlayerCommandService(PlayerProfileRepository playerProfileRepository,
                                       PlayerServerAdapter playerServerAdapter) {
        this.playerProfileRepository = playerProfileRepository;
        this.playerServerAdapter = playerServerAdapter;
    }

    @Override
    public void addCurrency(UUID playerId, Currency currency, int amount) {
        String currencyName = currency.getName();
        PlayerProfile profile = playerProfileRepository.get(playerId);

        Map<String, Integer> newCurrencies = profile.getCurrencies();
        int currentAmount = newCurrencies.getOrDefault(currencyName, 0);
        int newAmount = currentAmount + amount;
        newCurrencies.put(currencyName, newAmount);

        Map<String, Integer> newCurrenciesTotal = profile.getCurrenciesTotal();
        int currentAmountTotal = newCurrenciesTotal.getOrDefault(currencyName, 0);
        int newAmountTotal = currentAmountTotal + amount;
        newCurrenciesTotal.put(currencyName, newAmountTotal);

        PlayerProfile newProfile = profile.getCopyer()
                .withCurrencies(newCurrencies)
                .withCurrenciesTotal(newCurrenciesTotal)
                .copy();
        playerProfileRepository.save(newProfile);
    }

    @Override
    public void removeCurrency(UUID playerId, Currency currency, int amount) {
        String currencyName = currency.getName();
        PlayerProfile profile = playerProfileRepository.get(playerId);
        Map<String, Integer> newCurrencies = profile.getCurrencies();
        int currentAmount = newCurrencies.getOrDefault(currencyName, 0);
        if (currentAmount < amount) {
            throw new IllegalArgumentException("Failed to remove " + amount + " " + currencyName +
                    ", player doesn't have that much.");
        }

        int newAmount = currentAmount - amount;
        newCurrencies.put(currencyName, newAmount);
        PlayerProfile newProfile = profile.getCopyer()
                .withCurrencies(newCurrencies)
                .copy();
        playerProfileRepository.save(newProfile);
    }

    @Override
    public void update(UUID playerId) {
        // TODO also check Minecraft name in here?

        // TODO make sure this doesn't get called when the player just logs in, as their time last seen will be long ago

        // TODO also make sure this doesn't do anything when the player is offline, add isOnline to PlayerServerData
        // TODO player can log off but still be in the iterator of the updater
        PlayerProfile profile = playerProfileRepository.get(playerId);
        long newTimeLastSeen = System.currentTimeMillis();
        long newTimePlayed = profile.getTimePlayed() + (newTimeLastSeen - profile.getTimeLastSeen());
        PlayerProfile newProfile = profile.getCopyer()
                .withTimeLastSeen(newTimeLastSeen)
                .withTimePlayed(newTimePlayed)
                .copy();
        playerProfileRepository.save(newProfile);
    }

    @Override
    public void sendMessage(UUID playerId, String message) {
        playerServerAdapter.sendMessage(playerId, message);
    }

    @Override
    public void sendNotification(UUID playerId, String notification) {
        sendMessage(playerId, ColorCode.YELLOW + "[SERVER] " + notification);
    }
}
