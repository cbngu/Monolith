package gg.warcraft.monolith.app.world.portal.service;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.effect.Effect;
import gg.warcraft.monolith.api.entity.Entity;
import gg.warcraft.monolith.api.world.location.Location;
import gg.warcraft.monolith.api.world.location.OrientedLocation;
import gg.warcraft.monolith.api.world.portal.Portal;
import gg.warcraft.monolith.api.world.portal.service.PortalCommandService;
import gg.warcraft.monolith.api.world.portal.service.PortalRepository;
import gg.warcraft.monolith.app.world.portal.SimplePortal;

import java.util.function.Predicate;

public class DefaultPortalCommandService implements PortalCommandService {
    private final PortalRepository portalRepository;

    @Inject
    public DefaultPortalCommandService(PortalRepository portalRepository) {
        this.portalRepository = portalRepository;
    }

    @Override
    public void createPortal(Location entryLocation, OrientedLocation exitLocation, Predicate<Entity> predicate, Effect effect) {
        Portal portal = new SimplePortal(entryLocation, exitLocation, predicate, effect);
        portalRepository.save(portal);
    }

    @Override
    public void deletePortal(Location entryLocation) {
        Portal portal = portalRepository.getFor(entryLocation);
        if (portal == null) {
            return;
        }

        portalRepository.delete(portal);
        Effect effect = portal.getEffect();
        if (effect != null) {
            effect.cancel();
        }
    }
}
