package gg.warcraft.monolith.api.combat;

public interface CombatValueModifier {

    CombatValueModifierType getType();

    float getModifier();
}
