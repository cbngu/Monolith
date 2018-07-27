package gg.warcraft.monolith.api.combat;

import java.util.List;

public interface CombatValueFactory {

    CombatValue createCombatValue(float baseValue, List<CombatValueModifier> modifiers);
}
