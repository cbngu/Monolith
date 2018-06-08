package gg.warcraft.monolith.api.entity.status;

import gg.warcraft.monolith.api.entity.event.EntityDamageEvent;
import gg.warcraft.monolith.api.entity.event.EntityDeathEvent;
import gg.warcraft.monolith.api.entity.event.EntityHealthChangedEvent;
import gg.warcraft.monolith.api.entity.event.EntityHitEvent;

/**
 * A StatusEffect is an effect that is currently, for better or for worse, affecting an {@code Entity}.
 * <p>
 * TODO: this interface is a work in progress
 */
public interface StatusEffect {

    boolean hasExpired();

    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    // TODO: implement with combat module
    // default void onAbilityHitEvent(AbilityHitEvent event) {
    //
    // }

    default void onHitEvent(EntityHitEvent event) {

    }

    default void onDamageEvent(EntityDamageEvent event) {

    }

    default void onHealthChangedEvent(EntityHealthChangedEvent event) {

    }

    default void onDeathEvent(EntityDeathEvent event) {

    }

    /**
     * StatusEffect.Observer is a simple observer class that allows objects to subscribe to updates of the state of
     * a {@code StatusEffect}.
     */
    interface Observer {

        /**
         * @param effect The status effect that has expired. Can not be null.
         */
        void onExpired(StatusEffect effect);
    }
}
