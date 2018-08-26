package gg.warcraft.monolith.api.entity.team.service;

import gg.warcraft.monolith.api.entity.team.Team;

public interface TeamRepository {

    Team getTeam(String name);

    void save(Team team);
}
