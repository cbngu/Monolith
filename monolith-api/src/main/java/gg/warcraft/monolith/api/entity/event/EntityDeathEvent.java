package gg.warcraft.monolith.api.entity.event;

import gg.warcraft.monolith.api.world.ItemType;

import java.util.List;

/**
 * An EntityDamageEvent is fired whenever an {@code Entity} has died.
 * <p>
 * TODO: this interface is a work in progress
 */
public interface EntityDeathEvent extends EntityEvent {

    List<ItemType> getDrops();

    void setDrops(List<ItemType> drops);
}
