package gg.warcraft.monolith.api.entity.team.service;

import gg.warcraft.monolith.api.entity.team.Team;

import java.util.List;
import java.util.UUID;

public interface TeamQueryService {

    Team getTeam(String name);

    Team getTeam(UUID entityId);

    List<Team> getTeams();
}
