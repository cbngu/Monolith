package gg.warcraft.monolith.api.combat.value;

import gg.warcraft.monolith.api.combat.CombatSource;

import java.util.List;

public interface CombatValue {

    float getBaseValue();

    List<CombatValueModifier> getModifiers();

    float getModifiedValue();

    CombatSource getSource();
}
