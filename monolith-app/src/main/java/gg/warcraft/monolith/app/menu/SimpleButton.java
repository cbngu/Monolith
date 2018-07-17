package gg.warcraft.monolith.app.menu;

import gg.warcraft.monolith.api.item.ItemType;
import gg.warcraft.monolith.api.menu.Button;

import java.util.ArrayList;
import java.util.List;

public class SimpleButton implements Button {
    private final ItemType icon;
    private final String title;
    private final List<String> tooltip;
    private final Runnable action;

    public SimpleButton(ItemType icon, String title, List<String> tooltip, Runnable action) {
        this.icon = icon;
        this.title = title;
        this.tooltip = tooltip;
        this.action = action;
    }

    @Override
    public ItemType getIcon() {
        return icon;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public List<String> getTooltip() {
        return new ArrayList<>(tooltip);
    }

    @Override
    public Runnable getAction() {
        return action;
    }
}
