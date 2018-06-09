package gg.warcraft.monolith.api.world;

import gg.warcraft.monolith.api.util.Duration;

/**
 * A PotionEffect is a Minecraft status effect.
 */
public interface PotionEffect {

    /**
     * @return The type of this potion effect.
     */
    PotionType getType();

    /**
     * Returns the strength of this potion effect.
     * <p>
     * This strength value is 1-based compared to Spigot's {@code PotionEffect} amplifier being 0-based. A potion effect
     * with a strength value of 0 will have the same effect as no potion effect at all.
     *
     * @return The strength of this potion effect.
     */
    int getStrength();

    /**
     * @return The duration of this potion effect.
     */
    Duration getDuration();
}
