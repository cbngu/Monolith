package gg.warcraft.monolith.api.menu.service;

import gg.warcraft.monolith.api.menu.Menu;

import java.util.UUID;

public interface MenuRepository {

    Menu getMenu(UUID viewerId);

    void save(Menu menu);

    void delete(UUID viewerId);
}
