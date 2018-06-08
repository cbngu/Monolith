package gg.warcraft.monolith.api.entity;

import gg.warcraft.monolith.api.util.ColorCode;
import gg.warcraft.monolith.api.util.ColorHue;

/**
 * A Faction is a player's primary affiliation and determines the player's allies and enemies for the purpose of player
 * versus player implementations.
 * <p>
 * When a faction does not belong to a concrete {@code Alliance} the faction itself is considered to be the alliance.
 */
public interface Faction {

    /**
     * @return The name of this faction. Never null or empty.
     */
    String getName();

    /**
     * @return The color of this faction. Never null.
     */
    ColorHue getColor();

    /**
     * @return The color code of this faction. Never null.
     */
    ColorCode getChatColor();

    /**
     * @return The alliance this faction belongs to. Can be null.
     */
    Alliance getAlliance();
}
