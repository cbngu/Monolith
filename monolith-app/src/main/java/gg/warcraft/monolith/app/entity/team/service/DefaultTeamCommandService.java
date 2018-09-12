package gg.warcraft.monolith.app.entity.team.service;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.core.EventService;
import gg.warcraft.monolith.api.entity.Entity;
import gg.warcraft.monolith.api.entity.event.EntityTeamChangedEvent;
import gg.warcraft.monolith.api.entity.service.EntityQueryService;
import gg.warcraft.monolith.api.entity.team.Team;
import gg.warcraft.monolith.api.entity.team.service.TeamCommandService;
import gg.warcraft.monolith.api.entity.team.service.TeamRepository;
import gg.warcraft.monolith.app.entity.event.SimpleEntityTeamChangedEvent;

import java.util.UUID;

public class DefaultTeamCommandService implements TeamCommandService {
    private final TeamRepository teamRepository;
    private final EntityQueryService entityQueryService;
    private final EventService eventService;

    @Inject
    public DefaultTeamCommandService(TeamRepository teamRepository, EntityQueryService entityQueryService,
                                     EventService eventService) {
        this.teamRepository = teamRepository;
        this.entityQueryService = entityQueryService;
        this.eventService = eventService;
    }

    @Override
    public void registerTeam(Team team) {
        teamRepository.save(team);
    }

    @Override
    public void setTeam(Team team, UUID entityId) {
        Entity entity = entityQueryService.getEntity(entityId);
        Team previousTeam = entity.getTeam();

        teamRepository.save(team, entityId);

        EntityTeamChangedEvent entityTeamChangedEvent = new SimpleEntityTeamChangedEvent(entityId, entity.getType(),
                previousTeam, team);
        eventService.publish(entityTeamChangedEvent);
    }

    @Override
    public void removeFromTeam(UUID entityId) {
        Entity entity = entityQueryService.getEntity(entityId);
        Team previousTeam = entity.getTeam();

        teamRepository.delete(entityId);

        EntityTeamChangedEvent entityTeamChangedEvent = new SimpleEntityTeamChangedEvent(entityId, entity.getType(),
                previousTeam, null);
        eventService.publish(entityTeamChangedEvent);
    }
}
