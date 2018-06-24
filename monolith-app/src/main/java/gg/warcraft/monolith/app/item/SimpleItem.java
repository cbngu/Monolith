package gg.warcraft.monolith.app.item;

import gg.warcraft.monolith.api.item.Item;
import gg.warcraft.monolith.api.item.ItemType;

import java.util.List;

public class SimpleItem implements Item {
    private final ItemType type;
    private final String name;
    private final int stackSize;
    private final int damage;
    private final List<String> lore;

    public SimpleItem(ItemType type, String name, int stackSize, int damage, List<String> lore) {
        this.type = type;
        this.name = name;
        this.stackSize = stackSize;
        this.damage = damage;
        this.lore = lore;
    }

    @Override
    public ItemType getType() {
        return type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getStackSize() {
        return stackSize;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public List<String> getLore() {
        return lore;
    }
}
