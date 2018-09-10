package gg.warcraft.monolith.app.entity.service;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import gg.warcraft.monolith.api.core.EventService;
import gg.warcraft.monolith.api.entity.EntityProfile;
import gg.warcraft.monolith.api.entity.service.EntityProfileRepository;
import gg.warcraft.monolith.api.entity.service.EntityQueryService;
import gg.warcraft.monolith.api.entity.service.EntityServerAdapter;
import gg.warcraft.monolith.api.entity.team.Team;
import gg.warcraft.monolith.api.entity.team.service.TeamCommandService;
import gg.warcraft.monolith.api.util.TimeUtils;
import gg.warcraft.monolith.api.world.block.BlockTypeUtils;
import gg.warcraft.monolith.api.world.block.BlockUtils;
import gg.warcraft.monolith.api.world.service.WorldQueryService;
import gg.warcraft.monolith.app.entity.SimpleEntityProfile;

import java.util.Map;
import java.util.UUID;

public class DefaultEntityCommandService extends AbstractEntityCommandService {
    private final EntityProfileRepository entityProfileRepository;
    private final TeamCommandService teamCommandService;

    @Inject
    public DefaultEntityCommandService(EntityProfileRepository entityProfileRepository,
                                       TeamCommandService teamCommandService, EntityQueryService entityQueryService,
                                       EntityServerAdapter entityServerAdapter, WorldQueryService worldQueryService,
                                       EventService eventService, BlockUtils blockUtils, BlockTypeUtils blockTypeUtils,
                                       TimeUtils timeUtils) {
        super(entityQueryService, entityServerAdapter, worldQueryService, eventService, blockUtils, blockTypeUtils,
                timeUtils);
        this.entityProfileRepository = entityProfileRepository;
        this.teamCommandService = teamCommandService;
    }

    @Override
    public void setTeam(UUID entityId, Team team) {
        teamCommandService.setTeam(team, entityId);
    }

    @Override
    public void setData(UUID entityId, String data, String value) {
        Preconditions.checkNotNull(data);
        Preconditions.checkArgument(!data.isEmpty());
        if (value != null) {
            Preconditions.checkArgument(!value.isEmpty());
        }

        EntityProfile profile = entityProfileRepository.get(entityId);
        if (profile == null) {
            throw new IllegalArgumentException("Failed to set data for non-existent non-player entity with id "
                    + entityId + ", did you mean to use PlayerCommandService::setData?");
        }

        Map<String, String> newData = profile.getData();
        if (value != null) {
            newData.put(data, value);
        } else {
            newData.remove(data);
        }
        EntityProfile newProfile = new SimpleEntityProfile(profile.getEntityId(), newData);
        entityProfileRepository.save(newProfile);
    }
}
