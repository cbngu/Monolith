package gg.warcraft.monolith.api.entity.status;

import gg.warcraft.monolith.api.entity.event.EntityDamageEvent;
import gg.warcraft.monolith.api.entity.event.EntityDeathEvent;
import gg.warcraft.monolith.api.entity.event.EntityHealthChangedEvent;
import gg.warcraft.monolith.api.entity.event.EntityHitEvent;
import gg.warcraft.monolith.api.util.Duration;

import java.util.UUID;

/**
 * A StatusEffect is an effect that is currently, for better or for worse, affecting an {@code Entity}.
 * <p>
 * TODO: this interface is a work in progress
 */
public interface StatusEffect {

    /**
     * @return The id of the entity this effect belongs to. Never null.
     */
    UUID getEntityId();

    /**
     * @return The duration of this effect. Can be null if it should not automatically expire.
     */
    Duration getDuration();

    // TODO: implement with combat module
    ///**
    // * @param event Called when the entity this effect belongs to has hit with an ability.
    // */
    // default void onAbilityHitEvent(AbilityHitEvent event) {
    //
    // }

    /**
     * @param event Called when the entity this effect belongs to is hit.
     */
    default void onHitEvent(EntityHitEvent event) {

    }

    /**
     * @param event Called when the entity this effect belongs to is deals damage.
     */
    default void onDamageEvent(EntityDamageEvent event) {

    }

    /**
     * @param event Called when the entity this effect belongs to has gained or lost health.
     */
    default void onHealthChangedEvent(EntityHealthChangedEvent event) {

    }

    /**
     * @param event Called when the entity this effect belongs to has died.
     */
    default void onDeathEvent(EntityDeathEvent event) {

    }
}
