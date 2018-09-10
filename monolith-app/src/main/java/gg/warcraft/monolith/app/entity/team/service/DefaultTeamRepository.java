package gg.warcraft.monolith.app.entity.team.service;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import gg.warcraft.monolith.api.core.PersistenceService;
import gg.warcraft.monolith.api.entity.team.Team;
import gg.warcraft.monolith.api.entity.team.service.TeamRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Singleton
public class DefaultTeamRepository implements TeamRepository {
    private static final String ENTITY_TEAM_KEY_PREFIX = "entity:team:";

    private final PersistenceService persistenceService;
    private final Map<String, Team> teams;

    @Inject
    public DefaultTeamRepository(PersistenceService persistenceService) {
        this.persistenceService = persistenceService;
        this.teams = new HashMap<>();
    }

    String createTeamKey(UUID entityId) {
        return ENTITY_TEAM_KEY_PREFIX + entityId;
    }

    @Override
    public Team getTeam(String name) {
        return teams.get(name);
    }

    @Override
    public Team getTeam(UUID entityId) {
        String teamKey = createTeamKey(entityId);
        String team = persistenceService.get(teamKey);
        return teams.get(team);
    }

    @Override
    public List<Team> getTeams() {
        return new ArrayList<>(teams.values());
    }

    @Override
    public void save(Team team) {
        teams.put(team.getName(), team);
    }

    @Override
    public void save(Team team, UUID entityId) {
        String teamKey = createTeamKey(entityId);
        String teamName = team.getName();
        persistenceService.set(teamKey, teamName);
    }

    @Override
    public void delete(UUID entityId) {
        String teamKey = createTeamKey(entityId);
        persistenceService.delete(teamKey);
    }
}
