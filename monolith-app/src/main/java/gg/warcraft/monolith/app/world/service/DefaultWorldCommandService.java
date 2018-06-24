package gg.warcraft.monolith.app.world.service;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.item.Item;
import gg.warcraft.monolith.api.world.Location;
import gg.warcraft.monolith.api.world.block.Block;
import gg.warcraft.monolith.api.world.block.BlockType;
import gg.warcraft.monolith.api.world.service.WorldCommandService;
import gg.warcraft.monolith.api.world.service.WorldServerAdapter;

import java.util.List;

public class DefaultWorldCommandService implements WorldCommandService {
    private final WorldServerAdapter worldServerAdapter;

    @Inject
    public DefaultWorldCommandService(WorldServerAdapter worldServerAdapter) {
        this.worldServerAdapter = worldServerAdapter;
    }

    @Override
    public void setBlockType(Block block, BlockType type) {
        worldServerAdapter.setBlockType(block, type);
    }

    @Override
    public void dropItemsAt(List<Item> items, Location location) {
        worldServerAdapter.dropItemsAt(items, location);
    }
}
