package gg.warcraft.monolith.app.entity.event;

import gg.warcraft.monolith.api.combat.value.CombatValue;
import gg.warcraft.monolith.api.entity.EntityType;
import gg.warcraft.monolith.api.entity.event.AbstractEntityEvent;
import gg.warcraft.monolith.api.entity.event.EntityDamageEvent;

import java.util.UUID;

public class SimpleEntityDamageEvent extends AbstractEntityEvent implements EntityDamageEvent {
    private final CombatValue damage;

    public SimpleEntityDamageEvent(UUID entityId, EntityType entityType, CombatValue damage) {
        super(entityId, entityType);
        this.damage = damage;
    }

    @Override
    public CombatValue getDamage() {
        return damage;
    }
}
