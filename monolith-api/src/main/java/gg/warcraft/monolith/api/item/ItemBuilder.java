package gg.warcraft.monolith.api.item;

import java.util.List;

public interface ItemBuilder {

    ItemBuilder addLore(String lore);

    ItemBuilder withLore(List<String> lore);

    ItemBuilder withStackSize(int size);

    ItemBuilder withDamage(int damage);

    Item build();
}
