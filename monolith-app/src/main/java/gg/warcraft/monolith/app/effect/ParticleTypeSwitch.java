package gg.warcraft.monolith.app.effect;

import gg.warcraft.monolith.api.effect.ParticleType;

import java.util.function.Supplier;

public class ParticleTypeSwitch implements Supplier<ParticleType> {
    private final ParticleType primary;
    private final ParticleType secondary;
    private boolean getPrimary;

    public ParticleTypeSwitch(ParticleType primary, ParticleType secondary) {
        this.primary = primary;
        this.secondary = secondary;
        this.getPrimary = false;
    }

    @Override
    public ParticleType get() {
        getPrimary = !getPrimary;
        return getPrimary ? primary : secondary;
    }
}
