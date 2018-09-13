package gg.warcraft.monolith.app.world.portal.handler;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.entity.EntityType;
import gg.warcraft.monolith.api.entity.service.EntityCommandService;
import gg.warcraft.monolith.api.entity.service.EntityQueryService;
import gg.warcraft.monolith.api.world.portal.service.PortalQueryService;

public class PortalEntryTaskHandler implements Runnable {
    private final float TELEPORT_RADIUS = 1;

    private final PortalQueryService portalQueryService;
    private final EntityQueryService entityQueryService;
    private final EntityCommandService entityCommandService;

    @Inject
    public PortalEntryTaskHandler(PortalQueryService portalQueryService, EntityQueryService entityQueryService,
                                  EntityCommandService entityCommandService) {
        this.portalQueryService = portalQueryService;
        this.entityQueryService = entityQueryService;
        this.entityCommandService = entityCommandService;
    }

    @Override
    public void run() {
        portalQueryService.getAllPortals().forEach(portal ->
                entityQueryService.getNearbyEntities(portal.getEntryLocation(), TELEPORT_RADIUS).stream()
                        .filter(entity -> entity.getType() == EntityType.PLAYER)
                        .filter(entity -> portal.getPredicate().test(entity))
                        .forEach(entity -> entityCommandService.teleport(entity.getId(), portal.getExitLocation())));
    }
}
