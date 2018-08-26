package gg.warcraft.monolith.api.entity.team;

import gg.warcraft.monolith.api.util.ColorCode;
import gg.warcraft.monolith.api.util.ColorHue;

/**
 * A Team represents a group of players. Monolith considers teams to be hostile towards one another for the purpose of
 * player versus player implementations.
 */
public interface Team {

    /**
     * @return The name of this team. Never null or empty.
     */
    String getName();

    /**
     * @return The color of this team. Never null.
     */
    ColorHue getColor();

    /**
     * @return The color code of this team. Never null.
     */
    ColorCode getChatColor();
}
