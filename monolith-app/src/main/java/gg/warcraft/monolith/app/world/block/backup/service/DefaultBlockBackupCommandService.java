package gg.warcraft.monolith.app.world.block.backup.service;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.world.block.Block;
import gg.warcraft.monolith.api.world.block.backup.BlockBackup;
import gg.warcraft.monolith.api.world.block.backup.service.BlockBackupCommandService;
import gg.warcraft.monolith.api.world.block.backup.service.BlockBackupRepository;
import gg.warcraft.monolith.api.world.service.WorldServerAdapter;
import gg.warcraft.monolith.app.world.block.SimpleBlock;
import gg.warcraft.monolith.app.world.block.backup.SimpleBlockBackup;

import java.util.UUID;

public class DefaultBlockBackupCommandService implements BlockBackupCommandService {
    private final BlockBackupRepository blockBackupRepository;
    private final WorldServerAdapter worldServerAdapter;

    @Inject
    public DefaultBlockBackupCommandService(BlockBackupRepository blockBackupRepository,
                                            WorldServerAdapter worldServerAdapter) {
        this.blockBackupRepository = blockBackupRepository;
        this.worldServerAdapter = worldServerAdapter;
    }

    @Override
    public UUID createBlockBackup(Block block) {
        BlockBackup blockBackup = new SimpleBlockBackup(block);
        blockBackupRepository.save(blockBackup);
        return blockBackup.getId();
    }

    @Override
    public void restoreBlockBackup(UUID id) {
        BlockBackup blockBackup = blockBackupRepository.get(id);
        Block block = new SimpleBlock(blockBackup.getType(), blockBackup.getLocation());
        worldServerAdapter.setBlockType(block, block.getType());
        blockBackupRepository.delete(id);
    }
}
