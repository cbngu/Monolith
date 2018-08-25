package gg.warcraft.monolith.app.entity.event;

import gg.warcraft.monolith.api.combat.value.CombatValue;
import gg.warcraft.monolith.api.combat.value.CombatValueModifier;
import gg.warcraft.monolith.api.entity.EntityType;
import gg.warcraft.monolith.api.entity.event.AbstractEntityPreEvent;
import gg.warcraft.monolith.api.entity.event.EntityPreDamageEvent;
import gg.warcraft.monolith.app.combat.value.LazyCombatValue;

import java.util.List;
import java.util.UUID;

public class SimpleEntityPreDamageEvent extends AbstractEntityPreEvent implements EntityPreDamageEvent {
    private CombatValue damage;

    public SimpleEntityPreDamageEvent(UUID entityId, EntityType entityType, CombatValue damage, boolean cancelled) {
        super(entityId, entityType, cancelled);
        this.damage = damage;
    }

    @Override
    public CombatValue getDamage() {
        return damage;
    }

    @Override
    public void addModifier(CombatValueModifier modifier) {
        List<CombatValueModifier> newModifiers = damage.getModifiers();
        newModifiers.add(modifier);
        damage = new LazyCombatValue(damage.getBaseValue(), newModifiers, damage.getSource());
    }
}
