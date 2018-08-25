package gg.warcraft.monolith.api.combat.event;

import gg.warcraft.monolith.api.combat.ProjectileType;
import gg.warcraft.monolith.api.core.event.AbstractPreEvent;

import java.util.UUID;

public abstract class AbstractProjectilePreEvent extends AbstractPreEvent implements ProjectilePreEvent {
    private final UUID projectileId;
    private final ProjectileType projectileType;

    public AbstractProjectilePreEvent(UUID projectileId, ProjectileType projectileType, boolean cancelled) {
        super(cancelled);
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
