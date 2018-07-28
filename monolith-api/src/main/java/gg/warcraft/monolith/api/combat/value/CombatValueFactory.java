package gg.warcraft.monolith.api.combat.value;

import java.util.List;

public interface CombatValueFactory {

    CombatValue createCombatValue(float baseValue, List<CombatValueModifier> modifiers);
}
