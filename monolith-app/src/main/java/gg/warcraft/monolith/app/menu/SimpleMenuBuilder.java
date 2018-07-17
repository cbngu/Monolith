package gg.warcraft.monolith.app.menu;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import gg.warcraft.monolith.api.menu.Button;
import gg.warcraft.monolith.api.menu.Menu;
import gg.warcraft.monolith.api.menu.MenuBuilder;
import gg.warcraft.monolith.api.menu.MenuSize;

import java.util.HashMap;
import java.util.Map;

public class SimpleMenuBuilder implements MenuBuilder {
    private final String title;
    private final MenuSize size;

    private Map<Integer, Button> buttons;

    @Inject
    public SimpleMenuBuilder(@Assisted String title, @Assisted MenuSize size) {
        this.title = title;
        this.size = size;
        this.buttons = new HashMap<>();
    }

    @Override
    public void addButton(int slot, Button button) {
        Preconditions.checkNotNull(button);
        Preconditions.checkArgument(slot >= 0 && slot < size.getNumberOfSlots());
        buttons.put(slot, button);
    }

    @Override
    public void withButtons(Map<Integer, Button> buttons) {
        Preconditions.checkNotNull(buttons);
        buttons.forEach((slot, button) -> {
            Preconditions.checkNotNull(slot);
            Preconditions.checkArgument(slot >= 0 && slot < size.getNumberOfSlots());
            Preconditions.checkNotNull(button);
        });
        this.buttons = new HashMap<>(buttons);
    }

    @Override
    public Menu build() {
        return new SimpleMenu(title, size, buttons);
    }
}
