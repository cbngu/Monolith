package gg.warcraft.monolith.app.world.block.event;

import gg.warcraft.monolith.api.item.Item;
import gg.warcraft.monolith.api.world.block.Block;
import gg.warcraft.monolith.api.world.block.event.BlockPreBreakEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SimpleBlockPreBreakEvent extends SimpleBlockPreEvent implements BlockPreBreakEvent {
    private List<Item> alternativeDrops;
    private final UUID playerId;

    public SimpleBlockPreBreakEvent(Block block, List<Item> alternativeDrops, UUID playerId, boolean cancelled) {
        super(block, cancelled);
        this.alternativeDrops = alternativeDrops;
        this.playerId = playerId;
    }

    @Override
    public List<Item> getAlternativeDrops() {
        if (alternativeDrops == null) {
            return null;
        }
        return new ArrayList<>(alternativeDrops);
    }

    @Override
    public void setAlternativeDrops(List<Item> alternativeDrops) {
        if (alternativeDrops == null) {
            this.alternativeDrops = null;
        } else {
            this.alternativeDrops = new ArrayList<>(alternativeDrops);
        }
    }

    @Override
    public UUID getPlayerId() {
        return playerId;
    }
}
