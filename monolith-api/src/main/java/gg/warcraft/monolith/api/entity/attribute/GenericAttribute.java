package gg.warcraft.monolith.api.entity.attribute;

public enum GenericAttribute implements Attribute {
    MAX_HEALTH("generic.maxHealth", "Max Health"),
    FOLLOW_RANGE("generic.followRange", "Follow Range"),
    KNOCKBACK_RESISTANCE("generic.knockbackResistance", "Knockback Resistance"),
    MOVEMENT_SPEED("generic.movementSpeed", "Movement Speed"),
    FLYING_SPEED("generic.flyingSpeed", "Flying Speed"),
    ATTACK_DAMAGE("generic.attackDamage", "Attack Damage"),
    ATTACK_SPEED("generic.attackSpeed", "Attack Speed"),
    ARMOR("generic.armor", "Armor"),
    ARMOR_TOUGHNESS("generic.armorToughness", "Armor Toughness"),
    LUCK("generic.luck", "Luck");

    private final String id;
    private final String name;

    GenericAttribute(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }
}
