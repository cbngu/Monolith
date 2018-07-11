package gg.warcraft.monolith.api.world.block.event;

import gg.warcraft.monolith.api.world.block.BlockType;

import java.util.UUID;

public interface BlockPlaceEvent extends BlockEvent {

    BlockType getNewType();

    UUID getPlayerId();
}
