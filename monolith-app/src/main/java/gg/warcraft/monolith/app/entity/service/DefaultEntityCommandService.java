package gg.warcraft.monolith.app.entity.service;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.core.EventService;
import gg.warcraft.monolith.api.entity.EntityProfile;
import gg.warcraft.monolith.api.entity.service.EntityProfileRepository;
import gg.warcraft.monolith.api.entity.service.EntityQueryService;
import gg.warcraft.monolith.api.entity.service.EntityServerAdapter;
import gg.warcraft.monolith.api.util.TimeUtils;
import gg.warcraft.monolith.api.world.block.BlockTypeUtils;
import gg.warcraft.monolith.api.world.block.BlockUtils;
import gg.warcraft.monolith.api.world.service.WorldQueryService;
import gg.warcraft.monolith.app.entity.SimpleEntityProfile;

import java.util.Map;
import java.util.UUID;

public class DefaultEntityCommandService extends AbstractEntityCommandService {
    private final EntityProfileRepository entityProfileRepository;

    @Inject
    public DefaultEntityCommandService(EntityProfileRepository entityProfileRepository, EntityQueryService entityQueryService,
                                       EntityServerAdapter entityServerAdapter, WorldQueryService worldQueryService,
                                       EventService eventService, BlockUtils blockUtils, BlockTypeUtils blockTypeUtils,
                                       TimeUtils timeUtils) {
        super(entityQueryService, entityServerAdapter, worldQueryService, eventService, blockUtils, blockTypeUtils,
                timeUtils);
        this.entityProfileRepository = entityProfileRepository;
    }

    @Override
    public void setData(UUID entityId, String data, String value) {
        EntityProfile entityProfile = entityProfileRepository.get(entityId);
        Map<String, String> newEntityData = entityProfile.getData();
        if (value != null && !value.isEmpty()) {
            newEntityData.put(data, value);
        } else {
            newEntityData.remove(data);
        }
        EntityProfile newEntityProfile = new SimpleEntityProfile(entityProfile.getEntityId(), newEntityData);
        entityProfileRepository.save(newEntityProfile);
    }
}
