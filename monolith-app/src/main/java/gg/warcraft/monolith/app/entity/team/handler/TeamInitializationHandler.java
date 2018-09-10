package gg.warcraft.monolith.app.entity.team.handler;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import gg.warcraft.monolith.api.entity.EntityType;
import gg.warcraft.monolith.api.entity.event.EntityDeathEvent;
import gg.warcraft.monolith.api.entity.player.event.PlayerConnectEvent;
import gg.warcraft.monolith.api.entity.player.event.PlayerPermissionsChangedEvent;
import gg.warcraft.monolith.api.entity.team.service.TeamCommandService;

public class TeamInitializationHandler {
    private final TeamCommandService teamCommandService;

    @Inject
    public TeamInitializationHandler(TeamCommandService teamCommandService) {
        this.teamCommandService = teamCommandService;
    }

    @Subscribe
    public void onPlayerConnectEvent(PlayerConnectEvent event) {
        // TODO read player perms to find matching team
    }

    @Subscribe
    public void onPlayerPermissionsChangedEvent(PlayerPermissionsChangedEvent event) {
        // TODO read player perms to find matching team
    }

    @Subscribe
    public void onEntityDeathEvent(EntityDeathEvent event) {
        if (event.getEntityType() != EntityType.PLAYER) {
            teamCommandService.removeFromTeam(event.getEntityId());
        }
    }
}
