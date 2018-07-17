package gg.warcraft.monolith.api.menu;

import java.util.List;

public interface ButtonBuilder {

    void addTooltip(String tooltip);

    void withTooltip(List<String> tooltip);

    void withAction(Runnable action);

    Button build();
}
