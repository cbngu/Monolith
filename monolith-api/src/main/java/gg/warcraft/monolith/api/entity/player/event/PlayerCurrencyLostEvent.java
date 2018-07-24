package gg.warcraft.monolith.api.entity.player.event;

public interface PlayerCurrencyLostEvent extends PlayerEvent {

    /**
     * @return The name of the currency the player lost. Never null or empty.
     */
    String getCurrency();

    /**
     * @return The amount of currency the player lost.
     */
    int getAmount();

    /**
     * @return The new current amount of the currency the player has after losing the amount as stated in this event.
     */
    int getNewCurrent();
}
