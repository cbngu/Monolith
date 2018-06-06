package gg.warcraft.monolith.api.effect;

/**
 * ParticleType serves as an abstraction layer between Monolith plugin code and the eventual server implementation the
 * plugin is run on. It is identical to EffectLib's {@code ParticleEffect} and the server adapter will substitute its
 * values with the correct implementation during runtime.
 */
public enum ParticleType {
    EXPLOSION_NORMAL("minecraft:poof"),
    EXPLOSION_LARGE("minecraft:explosion"),
    EXPLOSION_HUGE("minecraft:explosion_emitter"),
    FIREWORKS_SPARK("minecraft:firework"),
    WATER_BUBBLE("minecraft:bubble"),
    WATER_SPLASH("minecraft:splash"),
    WATER_WAKE("minecraft:fishing"),
    SUSPENDED("minecraft:underwater"),
    CRIT("minecraft:crit"),
    CRIT_MAGIC("minecraft:enchanted_hit"),
    SMOKE_NORMAL("minecraft:smoke"),
    SMOKE_LARGE("minecraft:large_smoke"),
    SPELL("minecraft:effect"),
    SPELL_INSTANT("minecraft:instant_effect"),
    SPELL_MOB("minecraft:entity_effect"),
    SPELL_MOB_AMBIENT("minecraft:ambient_entity_effect"),
    SPELL_WITCH("minecraft:witch"),
    DRIP_WATER("minecraft:dripping_water"),
    DRIP_LAVA("minecraft:dripping_lava"),
    VILLAGER_HAPPY("minecraft:happy_villager"),
    VILLAGER_ANGRY("minecraft:angry_villager"),
    TOWN_AURA("minecraft:mycelium"),
    NOTE("minecraft:note"),
    PORTAL("minecraft:portal"),
    ENCHANTMENT_TABLE("minecraft:enchant"),
    FLAME("minecraft:flame"),
    LAVA("minecraft:lava"),
    CLOUD("minecraft:cloud"),
    REDSTONE("minecraft:dust"),
    SNOWBALL("minecraft:item_snowball"),
    SLIME("minecraft:item_slime"),
    HEART("minecraft:heart"),
    BARRIER("minecraft:barrier"),
    ITEM_CRACK("minecraft:item"),
    BLOCK_CRACK("minecraft:block"),
    BLOCK_DUST("minecraft:block"),
    WATER_DROP("minecraft:rain"),
    MOB_APPEARANCE("minecraft:elder_guardian"),
    DRAGON_BREATH("minecraft:dragon_breath"),
    END_ROD("minecraft:end_rod"),
    DAMAGE_INDICATOR("minecraft:damage_indicator"),
    SWEEP_ATTACK("minecraft:sweep_attack"),
    FALLING_DUST("minecraft:falling_dust"),
    TOTEM("minecraft:totem_of_undying"),
    SPIT("minecraft:spit"),
    SQUID_INK("minecraft:squid_ink"),
    BUBBLE_POP("minecraft:bubble_pop"),
    CURRENT_DOWN("minecraft:current_down"),
    BUBBLE_COLUMN_UP("minecraft:bubble_column_up"),
    NAUTILUS("minecraft:nautilus");

    private final String type;

    ParticleType(String type) {
        this.type = type;
    }

    /**
     * Returns the Minecraft type of this particle.
     *
     * @return The Minecraft type of this particle. Never null or empty.
     */
    public String getType() {
        return type;
    }
}
