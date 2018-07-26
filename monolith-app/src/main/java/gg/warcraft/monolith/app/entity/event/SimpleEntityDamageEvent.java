package gg.warcraft.monolith.app.entity.event;

import gg.warcraft.monolith.api.combat.CombatValue;
import gg.warcraft.monolith.api.entity.event.EntityDamageEvent;

import java.util.UUID;

public class SimpleEntityDamageEvent extends SimpleEntityEvent implements EntityDamageEvent {
    private final CombatValue damage;

    public SimpleEntityDamageEvent(UUID entityId, CombatValue damage) {
        super(entityId);
        this.damage = damage;
    }

    @Override
    public CombatValue getDamage() {
        return damage;
    }
}
