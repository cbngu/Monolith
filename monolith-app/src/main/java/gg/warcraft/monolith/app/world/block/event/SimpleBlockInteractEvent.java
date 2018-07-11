package gg.warcraft.monolith.app.world.block.event;

import gg.warcraft.monolith.api.item.Item;
import gg.warcraft.monolith.api.world.block.Block;
import gg.warcraft.monolith.api.world.block.BlockFace;
import gg.warcraft.monolith.api.world.block.event.BlockInteractEvent;
import gg.warcraft.monolith.api.world.block.event.BlockInteraction;

import java.util.UUID;

public class SimpleBlockInteractEvent extends SimpleBlockEvent implements BlockInteractEvent {
    private final BlockInteraction interaction;
    private final BlockFace clickedFace;
    private final Item itemInClickHand;
    private final UUID playerId;

    public SimpleBlockInteractEvent(Block block, BlockInteraction interaction, BlockFace clickedFace,
                                    Item itemInClickHand, UUID playerId) {
        super(block);
        this.interaction = interaction;
        this.clickedFace = clickedFace;
        this.itemInClickHand = itemInClickHand;
        this.playerId = playerId;
    }

    @Override
    public BlockInteraction getInteraction() {
        return interaction;
    }

    @Override
    public BlockFace getClickedBlockFace() {
        return clickedFace;
    }

    @Override
    public Item getItemInClickHand() {
        return itemInClickHand;
    }

    @Override
    public UUID getPlayerId() {
        return playerId;
    }
}
