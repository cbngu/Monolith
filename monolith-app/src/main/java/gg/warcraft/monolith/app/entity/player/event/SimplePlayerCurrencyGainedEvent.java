package gg.warcraft.monolith.app.entity.player.event;

import gg.warcraft.monolith.api.entity.player.event.PlayerCurrencyGainedEvent;

import java.util.UUID;

public class SimplePlayerCurrencyGainedEvent extends SimplePlayerEvent implements PlayerCurrencyGainedEvent {
    private final String currency;
    private final int amount;
    private final int newCurrent;
    private final int newLifetime;

    public SimplePlayerCurrencyGainedEvent(UUID playerId, String currency, int amount, int newCurrent,
                                           int newLifetime) {
        super(playerId);
        this.currency = currency;
        this.amount = amount;
        this.newCurrent = newCurrent;
        this.newLifetime = newLifetime;
    }

    @Override
    public String getCurrency() {
        return currency;
    }

    @Override
    public int getAmount() {
        return amount;
    }

    @Override
    public int getNewCurrent() {
        return newCurrent;
    }

    @Override
    public int getNewLifetime() {
        return newLifetime;
    }
}
