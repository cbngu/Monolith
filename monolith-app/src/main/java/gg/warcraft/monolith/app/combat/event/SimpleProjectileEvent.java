package gg.warcraft.monolith.app.combat.event;

import gg.warcraft.monolith.api.combat.ProjectileType;
import gg.warcraft.monolith.api.combat.event.ProjectileEvent;

import java.util.UUID;

public class SimpleProjectileEvent implements ProjectileEvent {
    private final UUID projectileId;
    private final ProjectileType projectileType;

    public SimpleProjectileEvent(UUID projectileId, ProjectileType projectileType) {
        this.projectileId = projectileId;
        this.projectileType = projectileType;
    }

    @Override
    public UUID getProjectileId() {
        return projectileId;
    }

    @Override
    public ProjectileType getProjectileType() {
        return projectileType;
    }
}
