package gg.warcraft.monolith.app.combat;

import gg.warcraft.monolith.api.combat.CombatValue;
import gg.warcraft.monolith.api.combat.CombatValueModifier;
import gg.warcraft.monolith.api.combat.CombatValueModifierType;
import gg.warcraft.monolith.api.util.Lazy;

import java.util.ArrayList;
import java.util.List;

public class LazyCombatValue implements CombatValue {
    private final float baseValue;
    private final List<CombatValueModifier> modifiers;
    private final Lazy<Float> modifiedValue;

    public LazyCombatValue(float baseValue, List<CombatValueModifier> modifiers) {
        this.baseValue = baseValue;
        this.modifiers = modifiers;
        this.modifiedValue = new Lazy<>(this::computeModifiedValue);
    }

    float computeModifiedValue() {
        float modifiedValue = baseValue;
        modifiedValue += modifiers.stream()
                .filter(modifier -> modifier.getType() == CombatValueModifierType.PERCENT)
                .map(modifier -> baseValue * modifier.getModifier())
                .reduce(Float::sum)
                .orElse(0f);
        modifiedValue += modifiers.stream()
                .filter(modifier -> modifier.getType() == CombatValueModifierType.FLAT)
                .map(CombatValueModifier::getModifier)
                .reduce(Float::sum)
                .orElse(0f);
        modifiedValue = modifiers.stream()
                .filter(modifier -> modifier.getType() == CombatValueModifierType.OVERRIDE)
                .map(CombatValueModifier::getModifier)
                .reduce(Float::max)
                .orElse(modifiedValue);
        return modifiedValue;
    }

    @Override
    public float getBaseValue() {
        return baseValue;
    }

    @Override
    public List<CombatValueModifier> getModifiers() {
        return new ArrayList<>(modifiers);
    }

    @Override
    public float getModifiedValue() {
        return modifiedValue.get();
    }
}
