package gg.warcraft.monolith.app.combat.event;

import gg.warcraft.monolith.api.combat.ProjectileType;
import gg.warcraft.monolith.api.combat.event.ProjectilePreEvent;
import gg.warcraft.monolith.app.core.SimplePreEvent;

import java.util.UUID;

public class SimpleProjectilePreEvent extends SimplePreEvent implements ProjectilePreEvent {
    private final UUID projectileId;
    private final ProjectileType projectileType;

    public SimpleProjectilePreEvent(UUID projectileId, ProjectileType projectileType, boolean cancelled) {
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
