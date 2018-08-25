package gg.warcraft.monolith.app.combat.event;

import gg.warcraft.monolith.api.combat.ProjectileType;
import gg.warcraft.monolith.api.combat.event.AbstractProjectilePreEvent;
import gg.warcraft.monolith.api.combat.event.ProjectilePreLaunchEvent;

import java.util.UUID;

public class SimpleProjectilePreLaunchEvent extends AbstractProjectilePreEvent implements ProjectilePreLaunchEvent {
    private final UUID shooterId;

    public SimpleProjectilePreLaunchEvent(UUID projectileId, ProjectileType projectileType, UUID shooterId,
                                          boolean cancelled) {
        super(projectileId, projectileType, cancelled);
        this.shooterId = shooterId;
    }

    @Override
    public UUID getShooterId() {
        return shooterId;
    }
}
