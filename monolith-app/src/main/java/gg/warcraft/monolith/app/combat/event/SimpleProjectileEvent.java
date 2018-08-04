package gg.warcraft.monolith.app.combat.event;

import gg.warcraft.monolith.api.combat.event.ProjectileEvent;

import java.util.UUID;

public class SimpleProjectileEvent implements ProjectileEvent {
    private final UUID projectileId;

    public SimpleProjectileEvent(UUID projectileId) {
        this.projectileId = projectileId;
    }

    @Override
    public UUID getProjectileId() {
        return projectileId;
    }
}
