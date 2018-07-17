package gg.warcraft.monolith.api.menu.service;

import gg.warcraft.monolith.api.menu.Menu;

import java.util.UUID;

public interface MenuQueryService {

    Menu getMenu(UUID viewerId);
}
