package gg.warcraft.monolith.app.combat.event;

import gg.warcraft.monolith.api.combat.event.ProjectilePreEvent;
import gg.warcraft.monolith.app.core.SimplePreEvent;

import java.util.UUID;

public class SimpleProjectilePreEvent extends SimplePreEvent implements ProjectilePreEvent {
    private final UUID projectileId;

    public SimpleProjectilePreEvent(UUID projectileId, boolean cancelled) {
        super(cancelled);
        this.projectileId = projectileId;
    }

    @Override
    public UUID getProjectileId() {
        return projectileId;
    }
}
