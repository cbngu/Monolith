package gg.warcraft.monolith.app.menu;

import com.google.common.base.Preconditions;
import gg.warcraft.monolith.api.item.ItemType;
import gg.warcraft.monolith.api.menu.Button;
import gg.warcraft.monolith.api.menu.ButtonBuilder;

import java.util.ArrayList;
import java.util.List;

public class SimpleButtonBuilder implements ButtonBuilder {
    private final ItemType icon;
    private final String title;

    private List<String> tooltip;
    private Runnable action;

    public SimpleButtonBuilder(ItemType icon, String title) {
        this.icon = icon;
        this.title = title;
        this.tooltip = new ArrayList<>();
        this.action = () -> {};
    }

    @Override
    public void addTooltip(String tooltip) {
        Preconditions.checkNotNull(tooltip);
        this.tooltip.add(tooltip);
    }

    @Override
    public void withTooltip(List<String> tooltip) {
        Preconditions.checkNotNull(tooltip);
        this.tooltip = new ArrayList<>(tooltip);
    }

    @Override
    public void withAction(Runnable action) {
        Preconditions.checkNotNull(action);
        this.action = action;
    }

    @Override
    public Button build() {
        return new SimpleButton(icon, title, tooltip, action);
    }
}
