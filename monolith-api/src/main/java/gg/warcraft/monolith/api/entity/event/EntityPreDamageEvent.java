package gg.warcraft.monolith.api.entity.event;

import gg.warcraft.monolith.api.combat.value.CombatValue;
import gg.warcraft.monolith.api.combat.value.CombatValueModifier;

public interface EntityPreDamageEvent extends EntityPreEvent {

    CombatValue getDamage();

    void addModifier(CombatValueModifier modifier);
}
