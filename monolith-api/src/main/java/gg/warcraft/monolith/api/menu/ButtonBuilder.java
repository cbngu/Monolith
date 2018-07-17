package gg.warcraft.monolith.api.menu;

import java.util.List;
import java.util.function.Consumer;

public interface ButtonBuilder {

    void addTooltip(String tooltip);

    void withTooltip(List<String> tooltip);

    void withAction(Consumer<Click> action);

    Button build();
}
