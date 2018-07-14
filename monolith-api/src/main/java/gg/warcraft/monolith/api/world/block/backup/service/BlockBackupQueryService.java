package gg.warcraft.monolith.api.world.block.backup.service;

import gg.warcraft.monolith.api.world.block.backup.BlockBackup;

import java.util.List;
import java.util.UUID;

public interface BlockBackupQueryService {

    /**
     * @param id The id.
     * @return The block backup with id. Can be null.
     */
    BlockBackup getBlockBackup(UUID id);

    /**
     * @return All currently persisted block backups. Never null, but can be empty. Items are never null.
     */
    List<BlockBackup> getAllBlockBackups();
}
