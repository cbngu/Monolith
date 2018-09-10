package gg.warcraft.monolith.app.entity.event;

import gg.warcraft.monolith.api.combat.value.CombatValue;
import gg.warcraft.monolith.api.entity.EntityType;
import gg.warcraft.monolith.api.entity.event.AbstractEntityEvent;
import gg.warcraft.monolith.api.entity.event.EntityAttackEvent;

import java.util.UUID;

public class SimpleEntityAttackEvent extends AbstractEntityEvent implements EntityAttackEvent {
    private final UUID attackerId;
    private final CombatValue damage;

    public SimpleEntityAttackEvent(UUID entityId, EntityType entityType, UUID attackerId, CombatValue damage) {
        super(entityId, entityType);
        this.attackerId = attackerId;
        this.damage = damage;
    }

    @Override
    public UUID getAttackerId() {
        return attackerId;
    }

    @Override
    public CombatValue getDamage() {
        return damage;
    }
}
