package gg.warcraft.monolith.api.entity;

import gg.warcraft.monolith.api.util.ColorCode;
import gg.warcraft.monolith.api.util.ColorHue;

/**
 * An Alliance consists of one or a number of factions (groups of players). Monolith considers alliances to be hostile
 * towards one another for the purpose of player versus player implementations.
 */
public interface Alliance {

    /**
     * @return The name of this alliance. Never null or empty.
     */
    String getName();

    /**
     * @return The color of this alliance. Never null.
     */
    ColorHue getColor();

    /**
     * @return The color code of this alliance. Never null.
     */
    ColorCode getChatColor();
}
