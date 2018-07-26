package gg.warcraft.monolith.api.combat;

import java.util.List;

public interface CombatValue {

    float getBaseValue();

    List<CombatValueModifier> getModifiers();

    float getModifiedValue();
}
