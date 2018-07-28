package gg.warcraft.monolith.app.entity.event;

import gg.warcraft.monolith.api.combat.value.CombatValue;
import gg.warcraft.monolith.api.combat.value.CombatValueModifier;
import gg.warcraft.monolith.api.entity.event.EntityPreDamageEvent;
import gg.warcraft.monolith.app.combat.value.LazyCombatValue;

import java.util.List;
import java.util.UUID;

public class SimpleEntityPreDamageEvent extends SimpleEntityPreEvent implements EntityPreDamageEvent {
    private CombatValue damage;

    public SimpleEntityPreDamageEvent(UUID entityId, CombatValue damage, boolean cancelled) {
        super(entityId, cancelled);
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
        damage = new LazyCombatValue(damage.getBaseValue(), newModifiers);
    }
}
