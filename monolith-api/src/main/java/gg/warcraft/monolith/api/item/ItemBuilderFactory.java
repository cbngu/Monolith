package gg.warcraft.monolith.api.item;

public interface ItemBuilderFactory {

    ItemBuilder createItemBuilder(ItemType type, String name);
}
