package gg.warcraft.monolith.app.menu.service;

import com.google.inject.Singleton;
import gg.warcraft.monolith.api.menu.Menu;
import gg.warcraft.monolith.api.menu.service.MenuRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Singleton
public class DefaultMenuRepository implements MenuRepository {
    private final Map<UUID, Menu> menus;

    public DefaultMenuRepository() {
        this.menus = new HashMap<>();
    }

    @Override
    public Menu getMenu(UUID viewerId) {
        return menus.get(viewerId);
    }

    @Override
    public void save(Menu menu) {
        menus.put(menu.getViewerId(), menu);
    }

    @Override
    public void delete(UUID viewerId) {
        menus.remove(viewerId);
    }
}
