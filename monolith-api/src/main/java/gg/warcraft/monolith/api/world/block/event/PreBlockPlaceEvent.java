package gg.warcraft.monolith.api.world.block.event;

import gg.warcraft.monolith.api.world.block.BlockType;

import java.util.UUID;

public interface PreBlockPlaceEvent extends PreBlockEvent {

    BlockType getNewType();

    UUID getPlayerId();

    void setNewType(BlockType type);
}
