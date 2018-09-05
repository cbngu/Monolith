package gg.warcraft.monolith.api.item;

/**
 * This utility is injectable.
 * <p>
 * The ItemTypeUtils utility serves as a point of entry into the block implementation. It provides methods to get
 * item types by id and data values and to easily determine the family of an item type.
 */
public interface ItemTypeUtils {

    /**
     * @param id The type id.
     * @return The item type for the given id. Can be null.
     */
    ItemType getType(int id);

    /**
     * @param id   The type id.
     * @param data The type data.
     * @return The item type for the given id and data. Can be null.
     */
    ItemType getType(int id, int data);

    /**
     * @param type The type.
     * @return True if the type is wool, false otherwise.
     */
    boolean isWool(ItemType type);
}
