package gg.warcraft.monolith.api.world.block.event;

import gg.warcraft.monolith.api.item.Item;
import gg.warcraft.monolith.api.world.block.BlockFace;

import java.util.UUID;

public interface BlockInteractEvent extends BlockEvent {

    BlockInteraction getInteraction();

    BlockFace getClickedBlockFace();

    Item getItemInClickHand();

    UUID getPlayerId();
}
