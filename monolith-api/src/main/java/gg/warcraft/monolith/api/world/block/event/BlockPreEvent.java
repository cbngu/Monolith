package gg.warcraft.monolith.api.world.block.event;

import gg.warcraft.monolith.api.core.PreEvent;
import gg.warcraft.monolith.api.world.block.Block;

public interface BlockPreEvent extends PreEvent {

    Block getBlock();
}
