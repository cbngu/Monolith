package gg.warcraft.monolith.api.menu;

import java.util.UUID;

public interface MenuBuilderFactory {

    MenuBuilder createMenuBuilder(UUID viewerId, String title, MenuSize size);
}
