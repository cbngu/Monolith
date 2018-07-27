package gg.warcraft.monolith.spigot.entity;

import gg.warcraft.monolith.api.entity.attribute.GenericAttribute;
import org.bukkit.attribute.Attribute;

public class GenericAttributeMapper {

    public Attribute map(GenericAttribute attribute) {
        switch (attribute) {
            case MAX_HEALTH:
                return Attribute.GENERIC_MAX_HEALTH;
            case FOLLOW_RANGE:
                return Attribute.GENERIC_FOLLOW_RANGE;
            case KNOCKBACK_RESISTANCE:
                return Attribute.GENERIC_KNOCKBACK_RESISTANCE;
            case MOVEMENT_SPEED:
                return Attribute.GENERIC_MOVEMENT_SPEED;
            case FLYING_SPEED:
                return Attribute.GENERIC_FLYING_SPEED;
            case ATTACK_DAMAGE:
                return Attribute.GENERIC_ATTACK_DAMAGE;
            case ATTACK_SPEED:
                return Attribute.GENERIC_ATTACK_SPEED;
            case ARMOR:
                return Attribute.GENERIC_ARMOR;
            case ARMOR_TOUGHNESS:
                return Attribute.GENERIC_ARMOR_TOUGHNESS;
            case LUCK:
                return Attribute.GENERIC_LUCK;
            default:
                throw new IllegalArgumentException("Failed to map unsupported attribute " + attribute.name());
        }
    }

    public GenericAttribute map(Attribute attribute) {
        switch (attribute) {
            case GENERIC_MAX_HEALTH:
                return GenericAttribute.MAX_HEALTH;
            case GENERIC_FOLLOW_RANGE:
                return GenericAttribute.FOLLOW_RANGE;
            case GENERIC_KNOCKBACK_RESISTANCE:
                return GenericAttribute.KNOCKBACK_RESISTANCE;
            case GENERIC_MOVEMENT_SPEED:
                return GenericAttribute.MOVEMENT_SPEED;
            case GENERIC_FLYING_SPEED:
                return GenericAttribute.FLYING_SPEED;
            case GENERIC_ATTACK_DAMAGE:
                return GenericAttribute.ATTACK_DAMAGE;
            case GENERIC_ATTACK_SPEED:
                return GenericAttribute.ATTACK_SPEED;
            case GENERIC_ARMOR:
                return GenericAttribute.ARMOR;
            case GENERIC_ARMOR_TOUGHNESS:
                return GenericAttribute.ARMOR_TOUGHNESS;
            case GENERIC_LUCK:
                return GenericAttribute.LUCK;
            case HORSE_JUMP_STRENGTH:
            case ZOMBIE_SPAWN_REINFORCEMENTS:
            default:
                throw new IllegalArgumentException("Failed to map unsupported attribute " + attribute.name());
        }
    }
}
