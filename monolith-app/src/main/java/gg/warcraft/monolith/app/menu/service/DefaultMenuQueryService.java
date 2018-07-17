package gg.warcraft.monolith.app.menu.service;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.menu.Menu;
import gg.warcraft.monolith.api.menu.service.MenuQueryService;
import gg.warcraft.monolith.api.menu.service.MenuRepository;

import java.util.UUID;

public class DefaultMenuQueryService implements MenuQueryService {
    private final MenuRepository menuRepository;

    @Inject
    public DefaultMenuQueryService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public Menu getMenu(UUID viewerId) {
        return menuRepository.getMenu(viewerId);
    }
}
