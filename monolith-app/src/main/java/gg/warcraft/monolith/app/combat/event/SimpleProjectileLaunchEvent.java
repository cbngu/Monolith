package gg.warcraft.monolith.app.combat.event;

import gg.warcraft.monolith.api.combat.ProjectileType;
import gg.warcraft.monolith.api.combat.event.AbstractProjectileEvent;
import gg.warcraft.monolith.api.combat.event.ProjectileLaunchEvent;

import java.util.UUID;

public class SimpleProjectileLaunchEvent extends AbstractProjectileEvent implements ProjectileLaunchEvent {
    private final UUID shooterId;

    public SimpleProjectileLaunchEvent(UUID projectileId, ProjectileType projectileType, UUID shooterId) {
        super(projectileId, projectileType);
        this.shooterId = shooterId;
    }

    @Override
    public UUID getShooterId() {
        return shooterId;
    }
}
