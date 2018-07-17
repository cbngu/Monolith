package gg.warcraft.monolith.api.menu;

import gg.warcraft.monolith.api.item.ItemType;

public interface ButtonBuilderFactory {

    ButtonBuilder createButtonBuilder(ItemType icon, String title);
}
