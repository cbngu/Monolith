package gg.warcraft.monolith.app.world.block.backup.service;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.world.block.backup.BlockBackup;
import gg.warcraft.monolith.api.world.block.backup.service.BlockBackupQueryService;
import gg.warcraft.monolith.api.world.block.backup.service.BlockBackupRepository;

import java.util.List;
import java.util.UUID;

public class DefaultBlockBackupQueryService implements BlockBackupQueryService {
    private final BlockBackupRepository blockBackupRepository;

    @Inject
    public DefaultBlockBackupQueryService(BlockBackupRepository blockBackupRepository) {
        this.blockBackupRepository = blockBackupRepository;
    }

    @Override
    public BlockBackup getBlockBackup(UUID id) {
        return blockBackupRepository.get(id);
    }

    @Override
    public List<BlockBackup> getAllBlockBackups() {
        return blockBackupRepository.getAll();
    }
}
