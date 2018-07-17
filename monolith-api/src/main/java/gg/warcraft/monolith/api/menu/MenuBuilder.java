package gg.warcraft.monolith.api.menu;

import java.util.Map;

public interface MenuBuilder {

    void addButton(int slot, Button button);

    void withButtons(Map<Integer, Button> buttons);

    Menu build();
}
