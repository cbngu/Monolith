package gg.warcraft.monolith.api.entity.status;

import gg.warcraft.monolith.api.combat.CombatSource;
import gg.warcraft.monolith.api.entity.event.EntityDamageEvent;
import gg.warcraft.monolith.api.entity.event.EntityDeathEvent;
import gg.warcraft.monolith.api.entity.event.EntityHealthChangedEvent;
import gg.warcraft.monolith.api.entity.event.EntityPreDamageEvent;
import gg.warcraft.monolith.api.entity.event.EntityPreFatalDamageEvent;
import gg.warcraft.monolith.api.util.Duration;

/**
 * A StatusEffect is an effect that is currently, for better or for worse, affecting an {@code Entity}.
 */
public interface StatusEffect extends CombatSource {

    /**
     * Returns the type of this effect.
     * <p>
     * A type helps identify groups of effects down the line. For example team based passives can be flagged as such and
     * easily replaced when a player changes teams.
     *
     * @return The type of this effect. Can be null, but not empty.
     */
    String getType();

    /**
     * @return The duration of this effect. Can be null if it should not automatically expire.
     */
    Duration getDuration();

    /**
     * @param event The event representing the damage the entity this status effect belongs to is about to take. Never
     *              null.
     */
    default void onEntityPreDamageEvent(EntityPreDamageEvent event) {
        // do nothing
    }

    /**
     * @param event The event representing the damage the entity this status effect belongs has taken. Never null.
     */
    default void onEntityDamageEvent(EntityDamageEvent event) {
        // do nothing
    }

    /**
     * @param event The event representing the change in health of the entity this status effect belongs to. Never
     *              null.
     */
    default void onEntityHealthChangedEvent(EntityHealthChangedEvent event) {
        // do nothing
    }

    /**
     * @param event The event representing the near death state of the entity this status effect belongs to is in.
     *              Never null.
     */
    default void onEntityPreFatalDamageEvent(EntityPreFatalDamageEvent event) {
        // do nothing
    }

    /**
     * @param event The event representing the death of the entity this status effect belongs to. Never null.
     */
    default void onEntityDeathEvent(EntityDeathEvent event) {
        // do nothing
    }

    default void onExpiry() {
        // do nothing
    }
}
