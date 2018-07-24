package gg.warcraft.monolith.app.entity;

import gg.warcraft.monolith.api.entity.Entity;
import gg.warcraft.monolith.api.entity.EntityTarget;
import gg.warcraft.monolith.api.world.block.Block;

public class SimpleEntityTarget implements EntityTarget {
    private final Entity entity;
    private final Block block;

    public SimpleEntityTarget(Entity entity, Block block) {
        this.entity = entity;
        this.block = block;
    }

    @Override
    public Entity getEntity() {
        return entity;
    }

    @Override
    public Block getBlock() {
        return block;
    }
}
