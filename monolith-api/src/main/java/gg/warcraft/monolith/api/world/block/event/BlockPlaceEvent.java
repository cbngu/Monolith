package gg.warcraft.monolith.api.world.block.event;

import gg.warcraft.monolith.api.world.block.BlockType;

public interface BlockPlaceEvent extends BlockEvent {

    BlockType getNewType();
}
