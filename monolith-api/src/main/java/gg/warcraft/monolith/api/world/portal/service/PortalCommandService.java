package gg.warcraft.monolith.api.world.portal.service;

import gg.warcraft.monolith.api.effect.Effect;
import gg.warcraft.monolith.api.entity.Entity;
import gg.warcraft.monolith.api.world.location.Location;
import gg.warcraft.monolith.api.world.location.OrientedLocation;

import java.util.function.Predicate;

public interface PortalCommandService {

    void createPortal(Location entryLocation, OrientedLocation exitLocation, Predicate<Entity> predicate, Effect effect);

    void deletePortal(Location entryLocation);
}
