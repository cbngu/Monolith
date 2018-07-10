package gg.warcraft.monolith.app.entity.service;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.entity.EntityData;
import gg.warcraft.monolith.api.entity.Team;
import gg.warcraft.monolith.api.entity.service.EntityDataRepository;
import gg.warcraft.monolith.api.entity.service.EntityQueryService;
import gg.warcraft.monolith.api.entity.service.EntityServerAdapter;
import gg.warcraft.monolith.api.util.TimeUtils;
import gg.warcraft.monolith.api.world.block.BlockTypeUtils;
import gg.warcraft.monolith.api.world.block.BlockUtils;
import gg.warcraft.monolith.api.world.service.WorldQueryService;
import gg.warcraft.monolith.app.entity.SimpleEntityData;

import java.util.UUID;

public class DefaultEntityCommandService extends AbstractEntityCommandService {
    private final EntityDataRepository entityDataRepository;

    @Inject
    public DefaultEntityCommandService(EntityDataRepository entityDataRepository, EntityQueryService entityQueryService,
                                       EntityServerAdapter entityServerAdapter, WorldQueryService worldQueryService,
                                       BlockUtils blockUtils, BlockTypeUtils blockTypeUtils, TimeUtils timeUtils) {
        super(entityQueryService, entityServerAdapter, worldQueryService, blockUtils, blockTypeUtils, timeUtils);
        this.entityDataRepository = entityDataRepository;
    }

    @Override
    public void setTeam(UUID entityId, Team team) {
        EntityData entityData = entityDataRepository.get(entityId);
        EntityData newEntityData = new SimpleEntityData(entityData.getEntityId(), team);
        entityDataRepository.save(newEntityData);
    }
}
