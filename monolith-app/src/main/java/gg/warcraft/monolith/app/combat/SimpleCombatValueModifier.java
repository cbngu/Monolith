package gg.warcraft.monolith.app.combat;

import gg.warcraft.monolith.api.combat.CombatValueModifier;
import gg.warcraft.monolith.api.combat.CombatValueModifierType;

public class SimpleCombatValueModifier implements CombatValueModifier {
    private final CombatValueModifierType type;
    private final float modifier;

    public SimpleCombatValueModifier(CombatValueModifierType type, float modifier) {
        this.type = type;
        this.modifier = modifier;
    }

    @Override
    public CombatValueModifierType getType() {
        return type;
    }

    @Override
    public float getModifier() {
        return modifier;
    }
}