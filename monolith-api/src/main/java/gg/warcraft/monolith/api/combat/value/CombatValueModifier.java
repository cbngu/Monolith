package gg.warcraft.monolith.api.combat.value;

public interface CombatValueModifier {

    CombatValueModifierType getType();

    float getModifier();
}
