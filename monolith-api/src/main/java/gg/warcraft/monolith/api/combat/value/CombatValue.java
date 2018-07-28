package gg.warcraft.monolith.api.combat.value;

import java.util.List;

public interface CombatValue {

    float getBaseValue();

    List<CombatValueModifier> getModifiers();

    float getModifiedValue();
}
