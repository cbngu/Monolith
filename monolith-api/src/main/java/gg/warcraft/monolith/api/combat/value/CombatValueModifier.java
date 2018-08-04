package gg.warcraft.monolith.api.combat.value;

import gg.warcraft.monolith.api.combat.CombatSource;

public interface CombatValueModifier {

    CombatValueModifierType getType();

    float getModifier();

    CombatSource getSource();
}
