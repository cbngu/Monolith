package gg.warcraft.monolith.api.entity.event;

import gg.warcraft.monolith.api.entity.team.Team;

public interface EntityTeamChangedEvent extends EntityEvent {

    Team getPreviousTeam();

    Team getNewTeam();
}
