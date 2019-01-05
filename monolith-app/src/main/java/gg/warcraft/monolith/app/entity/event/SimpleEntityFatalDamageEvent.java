package gg.warcraft.monolith.app.entity.event;

import gg.warcraft.monolith.api.combat.value.CombatValue;
import gg.warcraft.monolith.api.entity.EntityType;
import gg.warcraft.monolith.api.entity.event.AbstractEntityEvent;
import gg.warcraft.monolith.api.entity.event.EntityFatalDamageEvent;

import java.util.UUID;

public class SimpleEntityFatalDamageEvent extends AbstractEntityEvent implements EntityFatalDamageEvent {
    private final CombatValue damage;

    public SimpleEntityFatalDamageEvent(UUID entityId, EntityType entityType, CombatValue damage) {
        super(entityId, entityType);
        this.damage = damage;
    }

    @Override
    public CombatValue getDamage() {
        return damage;
    }
}
