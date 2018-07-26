package gg.warcraft.monolith.api.entity.event;

import gg.warcraft.monolith.api.combat.CombatValue;

public interface EntityDamageEvent extends EntityEvent {

    CombatValue getDamage();
}
