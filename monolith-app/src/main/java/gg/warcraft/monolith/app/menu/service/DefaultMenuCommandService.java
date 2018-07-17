package gg.warcraft.monolith.app.menu.service;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.menu.Menu;
import gg.warcraft.monolith.api.menu.service.MenuCommandService;
import gg.warcraft.monolith.api.menu.service.MenuRepository;
import gg.warcraft.monolith.api.menu.service.MenuServerAdapter;

import java.util.UUID;

public class DefaultMenuCommandService implements MenuCommandService {
    private final MenuServerAdapter menuServerAdapter;
    private final MenuRepository menuRepository;

    @Inject
    public DefaultMenuCommandService(MenuServerAdapter menuServerAdapter, MenuRepository menuRepository) {
        this.menuServerAdapter = menuServerAdapter;
        this.menuRepository = menuRepository;
    }

    @Override
    public void showMenu(Menu menu, UUID viewerId) {
        menuRepository.save(menu, viewerId);
        menuServerAdapter.showMenu(menu, viewerId);
    }

    @Override
    public void closeMenu(UUID viewerId) {
        menuRepository.delete(viewerId);
        menuServerAdapter.closeMenu(viewerId);
    }
}
