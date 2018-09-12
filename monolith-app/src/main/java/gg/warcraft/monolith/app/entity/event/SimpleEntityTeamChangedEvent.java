package gg.warcraft.monolith.app.entity.event;

import gg.warcraft.monolith.api.entity.EntityType;
import gg.warcraft.monolith.api.entity.event.AbstractEntityEvent;
import gg.warcraft.monolith.api.entity.event.EntityTeamChangedEvent;
import gg.warcraft.monolith.api.entity.team.Team;

import java.util.UUID;

public class SimpleEntityTeamChangedEvent extends AbstractEntityEvent implements EntityTeamChangedEvent {
    private final Team previousTeam;
    private final Team newTeam;

    public SimpleEntityTeamChangedEvent(UUID entityId, EntityType entityType, Team previousTeam, Team newTeam) {
        super(entityId, entityType);
        this.previousTeam = previousTeam;
        this.newTeam = newTeam;
    }

    @Override
    public Team getPreviousTeam() {
        return previousTeam;
    }

    @Override
    public Team getNewTeam() {
        return newTeam;
    }
}
