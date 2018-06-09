package gg.warcraft.monolith.api.world;

/**
 * PotionType serves as an abstraction layer between Monolith plugin code and the eventual server implementation the
 * plugin is run on. It is identical to Spigot's {@code PotionEffectType} and the server adapter will substitute its
 * values with the correct implementation during runtime.
 */
public enum PotionType {
    SPEED(1),
    SLOW(2),
    FAST_DIGGING(3),
    SLOW_DIGGING(4),
    INCREASE_DAMAGE(5),
    HEAL(6),
    HARM(7),
    JUMP(8),
    CONFUSION(9),
    REGENERATION(10),
    DAMAGE_RESISTANCE(11),
    FIRE_RESISTANCE(12),
    WATER_BREATHING(13),
    INVISIBILITY(14),
    BLINDNESS(15),
    NIGHT_VISION(16),
    HUNGER(17),
    WEAKNESS(18),
    POISON(19),
    WITHER(20),
    HEALTH_BOOST(21),
    ABSORPTION(22),
    SATURATION(23),
    GLOWING(24),
    LEVITATION(25),
    LUCK(26),
    UNLUCK(27);

    private static final String POTION_TYPE = "minecraft:potion";

    private final int id;

    PotionType(final int id) {
        this.id = id;
    }

    /**
     * @return The Minecraft type of the potion type. Never null or empty.
     */
    public String getType() {
        return POTION_TYPE;
    }

    /**
     * @return The Minecraft id of the potion type.
     */
    public int getId() {
        return id;
    }
}
