package gg.warcraft.monolith.app.combat.value;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import gg.warcraft.monolith.api.combat.CombatSource;
import gg.warcraft.monolith.api.combat.value.CombatValueModifier;
import gg.warcraft.monolith.api.combat.value.CombatValueModifierType;

public class SimpleCombatValueModifier implements CombatValueModifier {
    private final CombatValueModifierType type;
    private final float modifier;
    private final CombatSource source;

    @Inject
    public SimpleCombatValueModifier(@Assisted CombatValueModifierType type, @Assisted float modifier,
                                     @Assisted CombatSource source) {
        this.type = type;
        this.modifier = modifier;
        this.source = source;
    }

    @Override
    public CombatValueModifierType getType() {
        return type;
    }

    @Override
    public float getModifier() {
        return modifier;
    }

    @Override
    public CombatSource getSource() {
        return source;
    }
}
