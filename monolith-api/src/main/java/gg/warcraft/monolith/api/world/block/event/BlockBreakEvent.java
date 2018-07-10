package gg.warcraft.monolith.api.world.block.event;

import gg.warcraft.monolith.api.item.Item;

import java.util.List;

public interface BlockBreakEvent extends BlockEvent {

    List<Item> getDrops();
}
