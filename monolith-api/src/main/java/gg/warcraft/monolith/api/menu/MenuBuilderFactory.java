package gg.warcraft.monolith.api.menu;

public interface MenuBuilderFactory {

    MenuBuilder createMenuBuilder(String title, MenuSize size);
}
