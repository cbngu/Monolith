package gg.warcraft.monolith.app.world.block.backup;

import gg.warcraft.monolith.api.world.block.Block;
import gg.warcraft.monolith.api.world.block.BlockType;
import gg.warcraft.monolith.api.world.block.backup.BlockBackup;
import gg.warcraft.monolith.api.world.location.BlockLocation;

import java.util.UUID;

public class SimpleBlockBackup implements BlockBackup {
    private final UUID id;
    private final BlockType type;
    private final BlockLocation location;

    public SimpleBlockBackup(Block block) {
        this(UUID.randomUUID(), block.getType(), block.getLocation());
    }

    public SimpleBlockBackup(UUID id, BlockType type, BlockLocation location) {
        this.id = id;
        this.type = type;
        this.location = location;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public BlockType getType() {
        return type;
    }

    @Override
    public BlockLocation getLocation() {
        return location;
    }
}
