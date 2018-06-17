package gg.warcraft.monolith.api.world.block.backup.service;

import gg.warcraft.monolith.api.world.block.backup.BlockBackup;

import java.util.List;

public interface BlockBackupQueryService {

    /**
     * Returns all currently persisted block backups.
     *
     * @return All currently persisted block backups. Never null, but can be empty.
     */
    List<BlockBackup> getAllBlockBackups();
}
