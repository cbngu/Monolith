package gg.warcraft.monolith.app.menu;

import gg.warcraft.monolith.api.menu.Click;

import java.util.UUID;

public class SimpleClick implements Click {
    private final UUID clickerId;
    private final boolean isLeftClick;
    private final boolean isShiftClick;

    public SimpleClick(UUID clickerId, boolean isLeftClick, boolean isShiftClick) {
        this.clickerId = clickerId;
        this.isLeftClick = isLeftClick;
        this.isShiftClick = isShiftClick;
    }

    @Override
    public UUID getClickerId() {
        return clickerId;
    }

    @Override
    public boolean isLeftClick() {
        return isLeftClick;
    }

    @Override
    public boolean isRightClick() {
        return !isLeftClick;
    }

    @Override
    public boolean isShiftClick() {
        return isShiftClick;
    }

    @Override
    public boolean isShiftLeftClick() {
        return isShiftClick && isLeftClick;
    }

    @Override
    public boolean isShiftRightClick() {
        return isShiftClick && !isLeftClick;
    }
}
