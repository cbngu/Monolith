package gg.warcraft.monolith.app.menu;

import gg.warcraft.monolith.api.menu.Button;
import gg.warcraft.monolith.api.menu.Menu;
import gg.warcraft.monolith.api.menu.MenuSize;

import java.util.Map;

public class SimpleMenu implements Menu {
    private final String title;
    private final MenuSize size;
    private final Map<Integer, Button> buttons;

    public SimpleMenu(String title, MenuSize size, Map<Integer, Button> buttons) {
        this.title = title;
        this.size = size;
        this.buttons = buttons;
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
