package gg.warcraft.monolith.app.item;

import gg.warcraft.monolith.api.item.ItemType;
import gg.warcraft.monolith.api.item.Skull;

import java.util.List;

public class SimpleSkull extends SimpleItem implements Skull {
    private final String playerName;

    public SimpleSkull(String playerName, String name, int stackSize, int damage, List<String> lore) {
        super(ItemType.MOB_HEAD, name, stackSize, damage, lore);
        this.playerName = playerName;
    }

    @Override
    public String getPlayerName() {
        return playerName;
    }
}
