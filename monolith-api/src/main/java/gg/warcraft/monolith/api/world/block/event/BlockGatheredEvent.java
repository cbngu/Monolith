package gg.warcraft.monolith.api.world.block.event;

import java.util.UUID;

import gg.warcraft.monolith.api.world.block.Block;

public interface BlockGatheredEvent {

    Block getGatheredBlock();

    UUID getPlayerId();
}
