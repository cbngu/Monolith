package gg.warcraft.monolith.app.menu;

import gg.warcraft.monolith.api.menu.Button;
import gg.warcraft.monolith.api.menu.Menu;
import gg.warcraft.monolith.api.menu.MenuSize;

import java.util.Map;
import java.util.UUID;

public class SimpleMenu implements Menu {
    private final UUID viewerId;
    private final String title;
    private final MenuSize size;
    private final Map<Integer, Button> buttons;

    public SimpleMenu(UUID viewerId, String title, MenuSize size, Map<Integer, Button> buttons) {
        this.viewerId = viewerId;
        this.title = title;
        this.size = size;
        this.buttons = buttons;
    }

    @Override
    public UUID getViewerId() {
        return viewerId;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public MenuSize getSize() {
        return size;
    }

    @Override
    public Map<Integer, Button> getButtons() {
        return buttons;
    }
}
