package gg.warcraft.monolith.app.world.block.backup.service;

import com.google.inject.Singleton;
import gg.warcraft.monolith.api.persistence.PersistenceService;
import gg.warcraft.monolith.api.world.BlockLocation;
import gg.warcraft.monolith.api.world.World;
import gg.warcraft.monolith.api.world.WorldType;
import gg.warcraft.monolith.api.world.block.BlockType;
import gg.warcraft.monolith.api.world.block.BlockTypeUtils;
import gg.warcraft.monolith.api.world.block.backup.BlockBackup;
import gg.warcraft.monolith.api.world.block.backup.service.BlockBackupRepository;
import gg.warcraft.monolith.app.world.SimpleBlockLocation;
import gg.warcraft.monolith.app.world.SimpleWorld;
import gg.warcraft.monolith.app.world.block.backup.SimpleBlockBackup;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Singleton
public class DefaultBlockBackupRepository implements BlockBackupRepository {
    private static final String KEY_PREFIX = "blockbackup:";
    private static final String TYPE_ID = "typeid";
    private static final String TYPE_DATA = "typedata";
    private static final String LOCATION_WORLD = "locationworld";
    private static final String LOCATION_X = "locationx";
    private static final String LOCATION_Y = "locationy";
    private static final String LOCATION_Z = "locationz";

    private final PersistenceService persistenceService;
    private final BlockTypeUtils blockTypeUtils;

    @Inject
    public DefaultBlockBackupRepository(PersistenceService persistenceService, BlockTypeUtils blockTypeUtils) {
        this.persistenceService = persistenceService;
        this.blockTypeUtils = blockTypeUtils;
    }

    @Override
    public void save(BlockBackup blockBackup) {
        persistenceService.setMap(getDataKey(blockBackup.getId()), flatten(blockBackup));
    }

    @Override
    public BlockBackup get(UUID id) {
        Map<String, String> data = persistenceService.getMap(getDataKey(id));
        if (data.isEmpty()) {
            return null;
        }
        return new SimpleBlockBackup(id, getBlockTypeFromData(data), getLocationFromData(data));
    }

    @Override
    public List<BlockBackup> getAll() {
        return persistenceService.getAllKeys(KEY_PREFIX).stream()
                .map(dataKey -> get(getBlockBackupId(dataKey)))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(UUID id) {
        persistenceService.delete(getDataKey(id));
    }

    private String getDataKey(UUID id) {
        return KEY_PREFIX + id;
    }

    private BlockType getBlockTypeFromData(Map<String, String> data) {
        String typeId = data.get(TYPE_ID);
        String typeData = data.get(TYPE_DATA);
        return blockTypeUtils.getType(Integer.parseInt(typeId), Integer.parseInt(typeData));
    }

    private BlockLocation getLocationFromData(Map<String, String> data) {
        String locationWorld = data.get(LOCATION_WORLD);
        String locationX = data.get(LOCATION_X);
        String locationY = data.get(LOCATION_Y);
        String locationZ = data.get(LOCATION_Z);

        World world = new SimpleWorld(WorldType.valueOf(locationWorld));
        return new SimpleBlockLocation(world, Integer.parseInt(locationX), Integer.parseInt(locationY),
                Integer.parseInt(locationZ));
    }

    private UUID getBlockBackupId(String dataKey) {
        return UUID.fromString(dataKey.substring(dataKey.lastIndexOf(":") + 1));
    }

    private Map<String, String> flatten(BlockBackup blockBackup) {
        Map<String, String> flattenedBlockBackup = new HashMap<>();
        flattenedBlockBackup.put(TYPE_ID, String.valueOf(blockBackup.getType().getId()));
        flattenedBlockBackup.put(TYPE_DATA, String.valueOf(blockBackup.getType().getData()));
        flattenedBlockBackup.put(LOCATION_WORLD, blockBackup.getLocation().getWorld().getType().name());
        flattenedBlockBackup.put(LOCATION_X, String.valueOf(blockBackup.getLocation().getX()));
        flattenedBlockBackup.put(LOCATION_Y, String.valueOf(blockBackup.getLocation().getY()));
        flattenedBlockBackup.put(LOCATION_Z, String.valueOf(blockBackup.getLocation().getZ()));
        return flattenedBlockBackup;
    }
}
