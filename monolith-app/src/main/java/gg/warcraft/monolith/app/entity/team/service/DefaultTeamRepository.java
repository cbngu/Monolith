package gg.warcraft.monolith.app.entity.team.service;

import gg.warcraft.monolith.api.entity.team.Team;
import gg.warcraft.monolith.api.entity.team.service.TeamRepository;

import java.util.HashMap;
import java.util.Map;

public class DefaultTeamRepository implements TeamRepository {
    private final Map<String, Team> teams;

    public DefaultTeamRepository() {
        this.teams = new HashMap<>();
    }

    @Override
    public Team getTeam(String name) {
        return teams.get(name);
    }

    @Override
    public void save(Team team) {
        teams.put(team.getName(), team);
    }
}
