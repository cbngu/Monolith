package gg.warcraft.monolith.app.entity.player.event;

import gg.warcraft.monolith.api.entity.player.event.AbstractPlayerEvent;
import gg.warcraft.monolith.api.entity.player.event.PlayerCurrencyLostEvent;

import java.util.UUID;

public class SimplePlayerCurrencyLostEvent extends AbstractPlayerEvent implements PlayerCurrencyLostEvent {
    private final String currency;
    private final int amount;
    private final int newCurrent;

    public SimplePlayerCurrencyLostEvent(UUID playerId, String currency, int amount, int newCurrent) {
        super(playerId);
        this.currency = currency;
        this.amount = amount;
        this.newCurrent = newCurrent;
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
}
