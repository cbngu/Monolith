package gg.warcraft.monolith.api.world.block.event;

import gg.warcraft.monolith.api.world.block.BlockType;

public interface PreBlockPlaceEvent extends PreBlockEvent {

    BlockType getNewType();

    void setNewType(BlockType type);
}
