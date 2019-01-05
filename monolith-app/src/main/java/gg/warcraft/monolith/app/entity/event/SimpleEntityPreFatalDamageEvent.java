package gg.warcraft.monolith.app.entity.event;

import gg.warcraft.monolith.api.combat.value.CombatValue;
import gg.warcraft.monolith.api.entity.EntityType;
import gg.warcraft.monolith.api.entity.event.AbstractEntityPreEvent;
import gg.warcraft.monolith.api.entity.event.EntityPreFatalDamageEvent;

import java.util.UUID;

public class SimpleEntityPreFatalDamageEvent extends AbstractEntityPreEvent implements EntityPreFatalDamageEvent {
    private final CombatValue damage;

    public SimpleEntityPreFatalDamageEvent(UUID entityId, EntityType entityType, CombatValue damage,
                                           boolean cancelled) {
        super(entityId, entityType, cancelled);
        this.damage = damage;
    }

    @Override
    public CombatValue getDamage() {
        return damage;
    }
}
