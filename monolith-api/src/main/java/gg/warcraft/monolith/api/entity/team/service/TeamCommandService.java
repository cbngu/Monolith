package gg.warcraft.monolith.api.entity.team.service;

import gg.warcraft.monolith.api.entity.team.Team;

import java.util.UUID;

public interface TeamCommandService {

    void setTeam(Team team, UUID entityId);

    void registerTeam(Team team);

    void removeFromTeam(UUID entityId);
}
