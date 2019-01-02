package gg.warcraft.monolith.api.entity.player.event;

import gg.warcraft.monolith.api.entity.player.Statistic;

public interface PlayerStatisticChangedEvent extends PlayerEvent {

    /**
     * @return The statistic that changed for the player. Never null or empty.
     */
    Statistic getStatistic();

    /**
     * @return The amount the statistic changed by.
     */
    int getAmount();

    /**
     * @return The new current value of the statistic after applying the change this event represents.
     */
    int getNewCurrent();
}
