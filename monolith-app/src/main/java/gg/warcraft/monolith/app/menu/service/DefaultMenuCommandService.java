package gg.warcraft.monolith.app.menu.service;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.menu.Menu;
import gg.warcraft.monolith.api.menu.service.MenuCommandService;
import gg.warcraft.monolith.api.menu.service.MenuRepository;

import java.util.UUID;

public class DefaultMenuCommandService implements MenuCommandService {
    private final MenuRepository menuRepository;

    @Inject
    public DefaultMenuCommandService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public void showMenu(Menu menu) {
        menuRepository.save(menu);
    }

    @Override
    public void closeMenu(UUID viewerId) {
        menuRepository.delete(viewerId);
        // TODO
    }
}
