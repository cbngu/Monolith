package gg.warcraft.monolith.api.world.block.event;

import gg.warcraft.monolith.api.item.Item;
import gg.warcraft.monolith.api.world.block.BlockFace;

import java.util.UUID;

public interface PreBlockInteractEvent extends PreBlockEvent {

    BlockInteraction getInteraction();

    BlockFace getClickedBlockFace();

    Item getItemInClickHand();

    UUID getPlayerId();
}
