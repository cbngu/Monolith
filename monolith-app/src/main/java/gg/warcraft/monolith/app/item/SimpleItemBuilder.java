package gg.warcraft.monolith.app.item;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import gg.warcraft.monolith.api.item.Item;
import gg.warcraft.monolith.api.item.ItemBuilder;
import gg.warcraft.monolith.api.item.ItemType;
import gg.warcraft.monolith.api.util.ColorCode;

import java.util.ArrayList;
import java.util.List;

public class SimpleItemBuilder implements ItemBuilder {
    private final ItemType type;
    private final String name;

    private int stackSize;
    private int damage;
    private List<String> lore;

    @Inject
    public SimpleItemBuilder(@Assisted ItemType type, @Assisted String name) {
        this.type = type;
        this.name = name;
        this.stackSize = 1;
        this.damage = 0;
        this.lore = new ArrayList<>();
    }

    @Override
    public ItemBuilder addLore(String lore) {
        this.lore.add(ColorCode.WHITE + lore);
        return this;
    }

    @Override
    public ItemBuilder withLore(List<String> lore) {
        this.lore = lore;
        return this;
    }

    @Override
    public ItemBuilder withStackSize(int size) {
        this.stackSize = size;
        return this;
    }

    @Override
    public ItemBuilder withDamage(int damage) {
        this.damage = damage;
        return this;
    }

    @Override
    public Item build() {
        return new SimpleItem(type, name, stackSize, damage, lore);
    }
}
