package gg.warcraft.monolith.api.world.event;

import gg.warcraft.monolith.api.core.Event;
import gg.warcraft.monolith.api.world.block.Block;

public interface BlockEvent extends Event {

    Block getBlock();
}
