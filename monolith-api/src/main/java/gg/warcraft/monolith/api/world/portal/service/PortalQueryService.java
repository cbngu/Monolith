package gg.warcraft.monolith.api.world.portal.service;

import gg.warcraft.monolith.api.world.location.Location;
import gg.warcraft.monolith.api.world.portal.Portal;

import java.util.List;

public interface PortalQueryService {

    Portal getPortalAt(Location entryLocation);

    List<Portal> getAllPortals();
}
