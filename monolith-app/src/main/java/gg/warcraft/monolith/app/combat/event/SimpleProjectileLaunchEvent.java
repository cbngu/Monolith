package gg.warcraft.monolith.app.combat.event;

import gg.warcraft.monolith.api.combat.event.ProjectileLaunchEvent;

import java.util.UUID;

public class SimpleProjectileLaunchEvent extends SimpleProjectileEvent implements ProjectileLaunchEvent {
    private final UUID shooterId;

    public SimpleProjectileLaunchEvent(UUID projectileId, UUID shooterId) {
        super(projectileId);
        this.shooterId = shooterId;
    }

    @Override
    public UUID getShooterId() {
        return shooterId;
    }
}
