package gg.warcraft.monolith.api.world.block.backup.service;

import gg.warcraft.monolith.api.world.block.Block;

import java.util.UUID;

public interface BlockBackupCommandService {

    /**
     * Creates a new block backup for the given block.
     *
     * @param block The block.
     * @return The id of the new block backup.
     */
    UUID createBlockBackup(Block block);

    /**
     * Restores the block backup with the given id.
     *
     * @param id The id.
     */
    void restoreBlockBackup(UUID id);
}
