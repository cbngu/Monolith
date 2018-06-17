package gg.warcraft.monolith.api.world.block.backup.service;

import gg.warcraft.monolith.api.world.block.backup.BlockBackup;

import java.util.List;
import java.util.UUID;

public interface BlockBackupRepository {

    void save(BlockBackup blockBackup);

    BlockBackup get(UUID id);

    List<BlockBackup> getAll();

    void delete(UUID id);
}
