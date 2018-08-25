package gg.warcraft.monolith.api.combat.event;

import gg.warcraft.monolith.api.combat.ProjectileType;

import java.util.UUID;

public abstract class AbstractProjectileEvent implements ProjectileEvent {
    private final UUID projectileId;
    private final ProjectileType projectileType;

    public AbstractProjectileEvent(UUID projectileId, ProjectileType projectileType) {
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
