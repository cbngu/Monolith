package gg.warcraft.monolith.app.world;

import gg.warcraft.monolith.api.util.Duration;
import gg.warcraft.monolith.api.world.PotionEffect;
import gg.warcraft.monolith.api.world.PotionEffectType;

public class SimplePotionEffect implements PotionEffect {
    private final PotionEffectType type;
    private final int level;
    private final Duration duration;

    public SimplePotionEffect(PotionEffectType type, int level, Duration duration) {
        this.type = type;
        this.level = level;
        this.duration = duration;
    }

    @Override
    public PotionEffectType getType() {
        return type;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public Duration getDuration() {
        return duration;
    }
}
