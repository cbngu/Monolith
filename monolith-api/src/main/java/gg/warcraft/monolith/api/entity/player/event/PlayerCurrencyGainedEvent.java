package gg.warcraft.monolith.api.entity.player.event;

public interface PlayerCurrencyGainedEvent extends PlayerEvent {

    /**
     * @return The name of the currency the player gained. Never null or empty.
     */
    String getCurrency();

    /**
     * @return The amount of currency the player gained.
     */
    int getAmount();

    /**
     * @return The new current amount of the currency the player has after gaining the amount as stated in this event.
     */
    int getNewCurrent();

    /**
     * @return The new total amount of the given currency this player has accumulated over their lifetime on the server
     * after gaining the amount as stated in this event.
     */
    int getNewLifetime();
}
