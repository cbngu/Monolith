package gg.warcraft.monolith.api.menu;

import java.util.Map;

public interface Menu {

    /**
     * @return The title of this menu. Never null or empty.
     */
    String getTitle();

    /**
     * @return The size of this menu. Never null.
     */
    MenuSize getSize();

    /**
     * @return The buttons of this menu and the slots they are set in (0-based). Never null, but can be empty. Items are
     * never null.
     */
    Map<Integer, Button> getButtons();
}
