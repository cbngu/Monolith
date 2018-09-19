package gg.warcraft.monolith.api.world.block.event;

import gg.warcraft.monolith.api.world.block.Block;

import java.util.UUID;

public interface BlockPrePlaceEvent extends BlockPreEvent {

    Block getPlacedBlock();

    Block getPlacedAgainst();

    UUID getPlayerId();
}
