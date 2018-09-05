package gg.warcraft.monolith.api.item;

import java.util.List;

public interface Inventory {

    /**
     * @return All items in this inventory. Never null, but can be empty.
     */
    List<Item> getItems();

    /**
     * @param items The items to add to the inventory. Can not be null, but can be empty. Items can not be null.
     * @return A list of items that could not be added to the inventory. Never null, but can be empty.
     */
    List<Item> add(List<Item> items);

    /**
     * Clears the inventory.
     */
    void clear();

    /**
     * @param type The item type. Can not be null.
     * @return True if this inventory contains at least one item of the given item type, false otherwise.
     */
    boolean contains(ItemType type);

    /**
     * @param item The item. Can not be null.
     * @return True if this inventory contains at least one item that fully matches the item, false otherwise.
     */
    boolean contains(Item item);

    /**
     * Removes all items with the given item type from the inventory.
     *
     * @param type The item type. Can not be null.
     * @return True if any items were removed, false otherwise.
     */
    boolean remove(ItemType type);

    /**
     * Removes an item from the inventory that fully matches the given item. This means that if the inventory has three
     * stacks of item type X that have a size of 10 and this method is called with an item of type X with a stack size
     * of 20 two out of three of those stacks will be removed from the inventory.
     *
     * @param item The item. Can not be null.
     * @return True if the specified item could be removed, false otherwise.
     */
    boolean remove(Item item);
}
