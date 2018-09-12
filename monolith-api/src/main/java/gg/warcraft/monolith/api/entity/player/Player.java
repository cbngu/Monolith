package gg.warcraft.monolith.api.entity.player;

import gg.warcraft.monolith.api.entity.Entity;
import gg.warcraft.monolith.api.item.Inventory;

/**
 * A Player is a human actor on the server.
 */
public interface Player extends Entity {

    /**
     * @return The unix timestamp in milliseconds when this player connected this session, or the previous session if
     * they have since logged off.
     */
    long getTimeConnected();

    /**
     * @return The unix timestamp in milliseconds when this player first connected to the server.
     */
    long getTimeFirstConnected();

    /**
     * @return The unix timestamp in milliseconds when this player was last seen on the server.
     */
    long getTimeLastSeen();

    /**
     * @return The total amount of time in milliseconds this player has played on the server.
     */
    long getTimePlayed();

    /**
     * @param currency The currency. Can not be null or empty.
     * @return The amount of the given currency this player currently has.
     */
    int getCurrency(String currency);

    /**
     * @param currency The currency. Can not be null or empty.
     * @return The total amount of the given currency this player has accumulated over their lifetime on the server.
     */
    int getLifetimeCurrency(String currency);

    GameMode getGameMode();

    /**
     * @return The inventory of this player. Never null.
     */
    Inventory getInventory();

    /**
     * @return True if this player is sneaking, false otherwise.
     */
    boolean isSneaking();
}
