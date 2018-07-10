package gg.warcraft.monolith.api.world.block.event;

import gg.warcraft.monolith.api.item.Item;

import java.util.List;

public interface PreBlockBreakEvent extends PreBlockEvent {

    List<Item> getDrops();

    void setDrops(List<Item> drops);
}
