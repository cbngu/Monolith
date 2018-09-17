package gg.warcraft.monolith.api.item;

import java.util.List;

public interface Item {

    ItemType getType();

    String getName();

    int getStackSize();

    int getDamage();

    List<String> getLore();

    Item withType(ItemType type);

    Item withName(String name);

    Item withStackSize(int size);

    Item withDamage(int damage);

    Item withLore(List<String> lore);
}
