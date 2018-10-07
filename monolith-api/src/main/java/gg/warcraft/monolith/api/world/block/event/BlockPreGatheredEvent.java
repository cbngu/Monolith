package gg.warcraft.monolith.api.world.block.event;

import java.util.UUID;

import gg.warcraft.monolith.api.world.block.Block;

public interface BlockPreGatheredEvent {

    Block getGatheredBlock();

    UUID getPlayerId();
}
