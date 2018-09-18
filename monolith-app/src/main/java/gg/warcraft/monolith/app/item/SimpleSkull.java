package gg.warcraft.monolith.app.item;

import com.google.common.base.MoreObjects;
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

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this.getClass())
                .add("type", getType())
                .add("name", getName())
                .add("stackSize", getStackSize())
                .add("damage", getDamage())
                .add("lore", getLore())
                .add("playerName", getPlayerName())
                .toString();
    }
}
