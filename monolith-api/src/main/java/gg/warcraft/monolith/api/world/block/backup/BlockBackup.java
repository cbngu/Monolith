package gg.warcraft.monolith.api.world.block.backup;

import gg.warcraft.monolith.api.world.BlockLocation;
import gg.warcraft.monolith.api.world.block.BlockType;

import java.util.UUID;

public interface BlockBackup {

    /**
     * Returns the id of this backup.
     *
     * @return The id of this backup. Never null.
     */
    UUID getId();

    /**
     * Returns the type of the block this backup belongs to.
     *
     * @return The type of the block this backup belongs to. Never null.
     */
    BlockType getType();

    /**
     * Returns the location of the block this backup belongs to.
     *
     * @return The location of the block this backup belongs to. Never null.
     */
    BlockLocation getLocation();
}
