package gg.warcraft.monolith.api.entity.player;

import gg.warcraft.monolith.api.entity.EntityProfile;

import java.util.Map;
import java.util.UUID;

public interface PlayerProfile extends EntityProfile {

    /**
     * @return The id of the player this data belongs to. Never null.
     */
    UUID getPlayerId();

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

    Map<String, Integer> getCurrencies();

    Map<String, Integer> getCurrenciesTotal();

    PlayerProfileCopyer getCopyer();
}
