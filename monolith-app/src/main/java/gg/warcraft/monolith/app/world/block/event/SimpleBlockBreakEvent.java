package gg.warcraft.monolith.app.world.block.event;

import gg.warcraft.monolith.api.item.Item;
import gg.warcraft.monolith.api.world.block.Block;
import gg.warcraft.monolith.api.world.block.event.BlockBreakEvent;

import java.util.ArrayList;
import java.util.List;

public class SimpleBlockBreakEvent extends SimpleBlockEvent implements BlockBreakEvent {
    private final List<Item> drops;

    public SimpleBlockBreakEvent(Block block, List<Item> drops) {
        super(block);
        this.drops = drops;
    }

    @Override
    public List<Item> getDrops() {
        return new ArrayList<>(drops);
    }
}
