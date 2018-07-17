package gg.warcraft.monolith.api.menu;

import gg.warcraft.monolith.api.item.ItemType;

import java.util.List;

public interface Button {

    /**
     * @return The item type this button will appear as in the menu. Never null.
     */
    ItemType getIcon();

    /**
     * @return The title of this button. Never null or empty.
     */
    String getTitle();

    /**
     * @return A copy of the list of lines of the tooltip of this button. Never null, but can be empty. Items are never
     * null, but can be empty.
     */
    List<String> getTooltip();

    /**
     * @return The action that should happen when this button is pressed. Never null.
     */
    Runnable getAction();
}
