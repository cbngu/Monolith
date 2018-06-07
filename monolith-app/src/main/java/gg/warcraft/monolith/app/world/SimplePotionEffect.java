package gg.warcraft.monolith.app.world;

import gg.warcraft.monolith.api.util.Duration;
import gg.warcraft.monolith.api.world.PotionEffect;
import gg.warcraft.monolith.api.world.PotionType;

public class SimplePotionEffect implements PotionEffect {
    private final PotionType type;
    private final int strength;
    private final Duration duration;

    public SimplePotionEffect(PotionType type, int strength, Duration duration) {
        this.type = type;
        this.strength = strength;
        this.duration = duration;
    }

    @Override
    public PotionType getType() {
        return type;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public Duration getDuration() {
        return duration;
    }
}
