package gg.warcraft.monolith.api.world.block.event;

import gg.warcraft.monolith.api.item.Item;

import java.util.List;
import java.util.UUID;

public interface PreBlockBreakEvent extends PreBlockEvent {

    List<Item> getAlternativeDrops();

    UUID getPlayerId();

    void setAlternativeDrops(List<Item> drops);
}
