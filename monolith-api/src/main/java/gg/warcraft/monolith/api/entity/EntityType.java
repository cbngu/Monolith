package gg.warcraft.monolith.api.entity;

/**
 * EntityType serves as an abstraction layer between Monolith plugin code and the eventual server implementation the
 * plugin is run on. It is identical to Spigot's {@code EntityType} and the server adapter will substitute its
 * values with the correct implementation during runtime.
 */
public enum EntityType {
    DROPPED_ITEM("minecraft:item", 1),
    EXPERIENCE_ORB("minecraft:xp_orb", 2),
    AREA_EFFECT_CLOUD("minecraft:area_effect_cloud", 3),
    ELDER_GUARDIAN("minecraft:elder_guardian", 4),
    WITHER_SKELETON("minecraft:wither_skeleton", 5),
    STRAY("minecraft:stray", 6),
    EGG("minecraft:egg", 7),
    LEAD_KNOT("minecraft:leash_knot", 8),
    PAINTING("minecraft:painting", 9),
    ARROW("minecraft:arrow", 10),
    SNOWBALL("minecraft:snowball", 11),
    GHAST_FIREBALL("minecraft:fireball", 12),
    BLAZE_FIREBALL("minecraft:small_fireball", 13),
    ENDER_PEARL("minecraft:ender_pearl", 14),
    EYE_OF_ENDER("minecraft:eye_of_ender_signal", 15),
    SPLASH_POTION("minecraft:potion", 16),
    BOTTLE_O_ENCHANTING("minecraft:xp_bottle", 17),
    ITEM_FRAME("minecraft:item_frame", 18),
    WITHER_SKULL("minecraft:wither_skull", 19),
    PRIMED_TNT("minecraft:tnt", 20),
    FALLING_BLOCK("minecraft:falling_block", 21),
    FIREWORK_ROCKET("minecraft:fireworks_rocket", 22),
    HUSK("minecraft:husk", 23),
    SPECTRAL_ARROW("minecraft:spectral_arrow", 24),
    SHULKER_BULLET("minecraft:shulker_bullet", 25),
    DRAGON_FIREBALL("minecraft:dragon_fireball", 26),
    ZOMBIE_VILLAGER("minecraft:zombie_villager", 27),
    SKELETON_HORSE("minecraft:skeleton_horse", 28),
    ZOMBIE_HORSE("minecraft:zombie_horse", 29),
    ARMOR_STAND("minecraft:armor_stand", 30),
    DONKEY("minecraft:donkey", 31),
    MULE("minecraft:mule", 32),
    EVOCATION_FANGS("minecraft:evocation_fangs", 33),
    EVOKER("minecraft:evocation_illager", 34),
    VEX("minecraft:vex", 35),
    VINDICATOR("minecraft:vindication_illager", 36),
    ILLUSIONER("minecraft:illusion_illager", 37),
    MINECART_WITH_COMMAND_BLOCK("minecraft:commandblock_minecart", 40),
    BOAT("minecraft:boat", 41),
    MINECART("minecraft:minecart", 42),
    STORAGE_MINECART("minecraft:chest_minecart", 43),
    POWERED_MINECART("minecraft:furnace_minecart", 44),
    MINECART_WITH_TNT("minecraft:tnt_minecart", 45),
    MINECART_WITH_HOPPER("minecraft:hopper_minecart", 46),
    MINECART_WITH_SPAWNER("minecraft:spawner_minecart", 47),
    CREEPER("minecraft:creeper", 50),
    SKELETON("minecraft:skeleton", 51),
    SPIDER("minecraft:spider", 52),
    GIANT_ZOMBIE("minecraft:giant", 53),
    ZOMBIE("minecraft:zombie", 54),
    SLIME("minecraft:slime", 55),
    GHAST("minecraft:ghast", 56),
    ZOMBIE_PIGMAN("minecraft:zombie_pigman", 57),
    ENDERMAN("minecraft:enderman", 58),
    CAVE_SPIDER("minecraft:cave_spider", 59),
    SILVERFISH("minecraft:silverfish", 60),
    BLAZE("minecraft:blaze", 61),
    MAGMA_CUBE("minecraft:magma_cube", 62),
    ENDER_DRAGON("minecraft:ender_dragon", 63),
    WITHER("minecraft:wither", 64),
    BAT("minecraft:bat", 65),
    WITCH("minecraft:witch", 66),
    ENDERMITE("minecraft:endermite", 67),
    GUARDIAN("minecraft:guardian", 68),
    SHULKER("minecraft:shulker", 69),
    PIG("minecraft:pig", 90),
    SHEEP("minecraft:sheep", 91),
    COW("minecraft:cow", 92),
    CHICKEN("minecraft:chicken", 93),
    SQUID("minecraft:squid", 94),
    WOLF("minecraft:wolf", 95),
    MOOSHROOM("minecraft:mooshroom", 96),
    SNOW_GOLEM("minecraft:snowman", 97),
    OCELOT("minecraft:ocelot", 98),
    IRON_GOLEM("minecraft:villager_golem", 99),
    HORSE("minecraft:horse", 100),
    RABBIT("minecraft:rabiit", 101),
    POLAR_BEAR("minecraft:polar_bear", 102),
    LLAMA("minecraft:llama", 103),
    LLAMA_SPIT("minecraft:llama_spit", 104),
    PARROT("minecraft:parrot", 105),
    VILLAGER("minecraft:villager", 120),
    ENDER_CRYSTAL("minecraft:ender_crystal", 200),
    PLAYER("minecraft:player", -1);

    private final String type;
    private final int id;

    EntityType(final String type, final int id) {
        this.type = type;
        this.id = id;
    }

    /**
     * @return The Minecraft type of this entity type. Never null or empty.
     */
    public String getType() {
        return type;
    }

    /**
     * @return The Minecraft id of this entity type.
     */
    public int getId() {
        return id;
    }
}
