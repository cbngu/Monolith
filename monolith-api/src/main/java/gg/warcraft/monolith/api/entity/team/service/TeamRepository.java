package gg.warcraft.monolith.api.entity.team.service;

import gg.warcraft.monolith.api.entity.team.Team;

import java.util.List;
import java.util.UUID;

public interface TeamRepository {

    Team getTeam(String name);

    Team getTeam(UUID entityId);

    List<Team> getTeams();

    void save(Team team);

    void save(Team team, UUID entityId);

    void delete(UUID entityId);
}
