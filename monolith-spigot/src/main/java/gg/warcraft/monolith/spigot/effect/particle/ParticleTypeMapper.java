package gg.warcraft.monolith.spigot.effect.particle;

import de.slikey.effectlib.util.ParticleEffect;
import gg.warcraft.monolith.api.effect.ParticleType;

public class ParticleTypeMapper {

    ParticleEffect toParticleEffect(ParticleType type) {
        switch (type) {
            case EXPLOSION_NORMAL:
                return ParticleEffect.EXPLOSION_NORMAL;
            case EXPLOSION_LARGE:
                return ParticleEffect.EXPLOSION_LARGE;
            case EXPLOSION_HUGE:
                return ParticleEffect.EXPLOSION_HUGE;
            case FIREWORKS_SPARK:
                return ParticleEffect.FIREWORKS_SPARK;
            case WATER_BUBBLE:
                return ParticleEffect.WATER_BUBBLE;
            case WATER_SPLASH:
                return ParticleEffect.WATER_SPLASH;
            case WATER_WAKE:
                return ParticleEffect.WATER_WAKE;
            case SUSPENDED:
                return ParticleEffect.SUSPENDED;
            case CRIT:
                return ParticleEffect.CRIT;
            case CRIT_MAGIC:
                return ParticleEffect.CRIT_MAGIC;
            case SMOKE_NORMAL:
                return ParticleEffect.SMOKE_NORMAL;
            case SMOKE_LARGE:
                return ParticleEffect.SMOKE_LARGE;
            case SPELL:
                return ParticleEffect.SPELL;
            case SPELL_INSTANT:
                return ParticleEffect.SPELL_INSTANT;
            case SPELL_MOB:
                return ParticleEffect.SPELL_MOB;
            case SPELL_MOB_AMBIENT:
                return ParticleEffect.SPELL_MOB_AMBIENT;
            case SPELL_WITCH:
                return ParticleEffect.SPELL_WITCH;
            case DRIP_WATER:
                return ParticleEffect.DRIP_WATER;
            case DRIP_LAVA:
                return ParticleEffect.DRIP_LAVA;
            case VILLAGER_HAPPY:
                return ParticleEffect.VILLAGER_HAPPY;
            case VILLAGER_ANGRY:
                return ParticleEffect.VILLAGER_ANGRY;
            case TOWN_AURA:
                return ParticleEffect.TOWN_AURA;
            case NOTE:
                return ParticleEffect.NOTE;
            case PORTAL:
                return ParticleEffect.PORTAL;
            case ENCHANTMENT_TABLE:
                return ParticleEffect.ENCHANTMENT_TABLE;
            case FLAME:
                return ParticleEffect.FLAME;
            case LAVA:
                return ParticleEffect.LAVA;
            case CLOUD:
                return ParticleEffect.CLOUD;
            case REDSTONE:
                return ParticleEffect.REDSTONE;
            case SNOWBALL:
                return ParticleEffect.SNOWBALL;
            case SLIME:
                return ParticleEffect.SLIME;
            case HEART:
                return ParticleEffect.HEART;
            case BARRIER:
                return ParticleEffect.BARRIER;
            case ITEM_CRACK:
                return ParticleEffect.ITEM_CRACK;
            case BLOCK_CRACK:
                return ParticleEffect.BLOCK_CRACK;
            case BLOCK_DUST:
                return ParticleEffect.BLOCK_DUST;
            case WATER_DROP:
                return ParticleEffect.WATER_DROP;
            case MOB_APPEARANCE:
                return ParticleEffect.MOB_APPEARANCE;
            case DRAGON_BREATH:
                return ParticleEffect.DRAGON_BREATH;
            case END_ROD:
                return ParticleEffect.END_ROD;
            case DAMAGE_INDICATOR:
                return ParticleEffect.DAMAGE_INDICATOR;
            case SWEEP_ATTACK:
                return ParticleEffect.SWEEP_ATTACK;
            case FALLING_DUST:
                return ParticleEffect.FALLING_DUST;
            case TOTEM:
                return ParticleEffect.TOTEM;
            case SPIT:
                return ParticleEffect.SPIT;
            case SQUID_INK:
                return ParticleEffect.SQUID_INK;
            case BUBBLE_POP:
                return ParticleEffect.BUBBLE_POP;
            case CURRENT_DOWN:
                return ParticleEffect.CURRENT_DOWN;
            case BUBBLE_COLUMN_UP:
                return ParticleEffect.BUBBLE_COLUMN_UP;
            case NAUTILUS:
                return ParticleEffect.NAUTILUS;
            default:
                throw new IllegalArgumentException("Unsupported particle type " + type);
        }
    }
}
