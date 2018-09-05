package gg.warcraft.monolith.api.menu;

import com.google.inject.name.Named;
import gg.warcraft.monolith.api.item.ItemType;

public interface ButtonBuilderFactory {

    @Named("simple")
    ButtonBuilder createSimpleButtonBuilder(ItemType icon, String title);

    @Named("skull")
    ButtonBuilder createSkullButtonBuilder(String skullName, String title);
}
