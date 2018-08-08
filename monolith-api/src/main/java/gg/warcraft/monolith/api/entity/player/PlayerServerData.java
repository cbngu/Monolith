package gg.warcraft.monolith.api.entity.player;

import gg.warcraft.monolith.api.entity.EntityServerData;
import gg.warcraft.monolith.api.item.Item;

import java.util.List;

public interface PlayerServerData extends EntityServerData {

    /**
     * @return All items in the inventory of this player. Never null, but can be empty. Items are never null.
     */
    List<Item> getInventory();

    /**
     * @return True if this player is sneaking, false otherwise.
     */
    boolean isSneaking();
}
