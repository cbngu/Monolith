package gg.warcraft.monolith.app.combat.event;

import gg.warcraft.monolith.api.combat.event.ProjectilePreLaunchEvent;

import java.util.UUID;

public class SimpleProjectilePreLaunchEvent extends SimpleProjectilePreEvent implements ProjectilePreLaunchEvent {
    private final UUID shooterId;

    public SimpleProjectilePreLaunchEvent(UUID projectileId, UUID shooterId, boolean cancelled) {
        super(projectileId, cancelled);
        this.shooterId = shooterId;
    }

    @Override
    public UUID getShooterId() {
        return shooterId;
    }
}
