package gg.warcraft.monolith.api.combat;

/**
 * This utility is injectable.
 * <p>
 * The PotionEffectTypeUtils utility services as a point of entry into the potion effect implementation. It provides
 * a method to get potion effect types by id.
 */
public interface PotionEffectTypeUtils {

    /**
     * @param id The type id.
     * @return The potion effect type for the given id. Can be null.
     */
    PotionEffectType getType(int id);
}
