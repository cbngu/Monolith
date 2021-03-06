package gg.warcraft.monolith.api.entity.player;

import gg.warcraft.monolith.api.entity.EntityServerData;
import gg.warcraft.monolith.api.item.Inventory;

public interface PlayerServerData extends EntityServerData {

    GameMode getGameMode();

    /**
     * @return The inventory of this player. Never null.
     */
    Inventory getInventory();

    /**
     * @return True if this player is sneaking, false otherwise.
     */
    boolean isSneaking();
}
