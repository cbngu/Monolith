package gg.warcraft.monolith.app.entity.team.service;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.entity.team.Team;
import gg.warcraft.monolith.api.entity.team.service.TeamQueryService;
import gg.warcraft.monolith.api.entity.team.service.TeamRepository;

import java.util.List;
import java.util.UUID;

public class DefaultTeamQueryService implements TeamQueryService {
    private final TeamRepository teamRepository;

    @Inject
    public DefaultTeamQueryService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Team getTeam(String name) {
        return teamRepository.getTeam(name);
    }

    @Override
    public Team getTeam(UUID entityId) {
        return teamRepository.getTeam(entityId);
    }

    @Override
    public List<Team> getTeams() {
        return teamRepository.getTeams();
    }
}
