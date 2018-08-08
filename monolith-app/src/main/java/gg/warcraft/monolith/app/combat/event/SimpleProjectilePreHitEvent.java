package gg.warcraft.monolith.app.combat.event;

import gg.warcraft.monolith.api.combat.ProjectileType;
import gg.warcraft.monolith.api.combat.event.ProjectilePreHitEvent;
import gg.warcraft.monolith.api.world.block.Block;

import java.util.UUID;

public class SimpleProjectilePreHitEvent extends SimpleProjectilePreEvent implements ProjectilePreHitEvent {
    private final Block block;
    private final UUID entityId;

    public SimpleProjectilePreHitEvent(UUID projectileId, ProjectileType projectileType, Block block, UUID entityId,
                                       boolean cancelled) {
        super(projectileId, projectileType, cancelled);
        this.block = block;
        this.entityId = entityId;
    }

    @Override
    public Block getBlock() {
        return block;
    }

    @Override
    public UUID getEntityId() {
        return entityId;
    }
}
