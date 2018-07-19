package gg.warcraft.monolith.app.entity.service;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.entity.EntityProfile;
import gg.warcraft.monolith.api.entity.Team;
import gg.warcraft.monolith.api.entity.service.EntityProfileRepository;
import gg.warcraft.monolith.api.entity.service.EntityQueryService;
import gg.warcraft.monolith.api.entity.service.EntityServerAdapter;
import gg.warcraft.monolith.api.util.TimeUtils;
import gg.warcraft.monolith.api.world.block.BlockTypeUtils;
import gg.warcraft.monolith.api.world.block.BlockUtils;
import gg.warcraft.monolith.api.world.service.WorldQueryService;
import gg.warcraft.monolith.app.entity.SimpleEntityProfile;

import java.util.UUID;

public class DefaultEntityCommandService extends AbstractEntityCommandService {
    private final EntityProfileRepository entityProfileRepository;

    @Inject
    public DefaultEntityCommandService(EntityProfileRepository entityProfileRepository, EntityQueryService entityQueryService,
                                       EntityServerAdapter entityServerAdapter, WorldQueryService worldQueryService,
                                       BlockUtils blockUtils, BlockTypeUtils blockTypeUtils, TimeUtils timeUtils) {
        super(entityQueryService, entityServerAdapter, worldQueryService, blockUtils, blockTypeUtils, timeUtils);
        this.entityProfileRepository = entityProfileRepository;
    }

    @Override
    public void setTeam(UUID entityId, Team team) {
        EntityProfile entityProfile = entityProfileRepository.get(entityId);
        EntityProfile newEntityProfile = new SimpleEntityProfile(entityProfile.getEntityId(), team);
        entityProfileRepository.save(newEntityProfile);
    }
}
