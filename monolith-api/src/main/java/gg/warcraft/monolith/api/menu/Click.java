package gg.warcraft.monolith.api.menu;

import java.util.UUID;

public interface Click {

    UUID getClickerId();

    boolean isLeftClick();

    boolean isRightClick();

    boolean isShiftClick();

    boolean isShiftLeftClick();

    boolean isShiftRightClick();
}
