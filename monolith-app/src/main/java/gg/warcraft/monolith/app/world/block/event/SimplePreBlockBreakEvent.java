package gg.warcraft.monolith.app.world.block.event;

import gg.warcraft.monolith.api.item.Item;
import gg.warcraft.monolith.api.world.block.Block;
import gg.warcraft.monolith.api.world.block.event.PreBlockBreakEvent;

import java.util.List;

public class SimplePreBlockBreakEvent extends SimplePreBlockEvent implements PreBlockBreakEvent {
    private List<Item> drops;

    public SimplePreBlockBreakEvent(Block block, List<Item> drops) {
        super(block);
        this.drops = drops;
    }

    @Override
    public List<Item> getDrops() {
        return drops;
    }

    @Override
    public void setDrops(List<Item> drops) {
        this.drops = drops;
    }
}
