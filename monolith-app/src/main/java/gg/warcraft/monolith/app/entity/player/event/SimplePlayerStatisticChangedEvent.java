package gg.warcraft.monolith.app.entity.player.event;

import gg.warcraft.monolith.api.entity.player.Statistic;
import gg.warcraft.monolith.api.entity.player.event.AbstractPlayerEvent;
import gg.warcraft.monolith.api.entity.player.event.PlayerStatisticChangedEvent;

import java.util.UUID;

public class SimplePlayerStatisticChangedEvent extends AbstractPlayerEvent implements PlayerStatisticChangedEvent {
    private final Statistic statistic;
    private final int amount;
    private final int newCurrent;

    public SimplePlayerStatisticChangedEvent(UUID playerId, Statistic statistic, int amount, int newCurrent) {
        super(playerId);
        this.statistic = statistic;
        this.amount = amount;
        this.newCurrent = newCurrent;
    }

    @Override
    public Statistic getStatistic() {
        return statistic;
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
