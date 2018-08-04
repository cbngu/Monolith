package gg.warcraft.monolith.app.combat.event;

import gg.warcraft.monolith.api.combat.event.ProjectileHitEvent;
import gg.warcraft.monolith.api.world.block.Block;

import java.util.UUID;

public class SimpleProjectileHitEvent extends SimpleProjectileEvent implements ProjectileHitEvent {
    private final Block block;
    private final UUID entityId;

    public SimpleProjectileHitEvent(UUID projectileId, Block block, UUID entityId) {
        super(projectileId);
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
