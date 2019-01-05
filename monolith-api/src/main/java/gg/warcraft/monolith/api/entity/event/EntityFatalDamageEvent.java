package gg.warcraft.monolith.api.entity.event;

import gg.warcraft.monolith.api.combat.value.CombatValue;

public interface EntityFatalDamageEvent extends EntityEvent {

    CombatValue getDamage();
}
