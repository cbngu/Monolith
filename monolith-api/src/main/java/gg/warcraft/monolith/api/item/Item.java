package gg.warcraft.monolith.api.item;

import java.util.List;

public interface Item {

    ItemType getType();

    String getName();

    int getStackSize();

    int getDamage();

    List<String> getLore();
}
