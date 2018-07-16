package gg.warcraft.monolith.api.entity;

import gg.warcraft.monolith.api.world.block.Block;

/**
 * An {@code EntityTarget} represents the entity and or block that are currently being targeted by a principal entity
 * given a certain range.
 * If not null, the returned entity is the closest entity the principal entity has targeted with their crosshair. If the
 * returned entity is null then the principal entity is either not looking at another entity or they were out of range.
 * A block will be returned regardless of whether an entity was returned. If an entity is between the principal entity
 * and a block is within range both will be returned. If the returned block is null the principal entity is either
 * looking into the sky or the first solid block ({@see BlockTypeUtils}) is out of range.
 */
public interface EntityTarget {

    /**
     * @return The entity that is being targeted. Can be null.
     */
    Entity getEntity();

    /**
     * @return The block that is being targeted. Can be null.
     */
    Block getBlock();
}
