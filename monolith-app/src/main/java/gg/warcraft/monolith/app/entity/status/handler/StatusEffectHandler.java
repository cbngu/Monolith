package gg.warcraft.monolith.app.entity.status.handler;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import gg.warcraft.monolith.api.entity.event.EntityDamageEvent;
import gg.warcraft.monolith.api.entity.event.EntityDeathEvent;
import gg.warcraft.monolith.api.entity.event.EntityHealthChangedEvent;
import gg.warcraft.monolith.api.entity.event.EntityPreDamageEvent;
import gg.warcraft.monolith.api.entity.event.EntityPreFatalDamageEvent;
import gg.warcraft.monolith.api.entity.player.event.PlayerDisconnectEvent;
import gg.warcraft.monolith.api.entity.player.service.PlayerQueryService;
import gg.warcraft.monolith.api.entity.status.Status;
import gg.warcraft.monolith.api.entity.status.service.StatusQueryService;
import gg.warcraft.monolith.api.entity.status.service.StatusRepository;

import java.util.UUID;

public class StatusEffectHandler {
    private final StatusQueryService statusQueryService;
    private final StatusRepository statusRepository;
    private final PlayerQueryService playerQueryService;

    @Inject
    public StatusEffectHandler(StatusQueryService statusQueryService, StatusRepository statusRepository,
                               PlayerQueryService playerQueryService) {
        this.statusQueryService = statusQueryService;
        this.statusRepository = statusRepository;
        this.playerQueryService = playerQueryService;
    }

    @Subscribe
    public void onEntityPreDamageEvent(EntityPreDamageEvent event) {
        UUID entityId = event.getEntityId();
        Status entityStatus = statusQueryService.getStatus(entityId);
        entityStatus.getEffects().forEach(effect -> effect.onEntityPreDamageEvent(event));
    }

    @Subscribe
    public void onEntityDamageEvent(EntityDamageEvent event) {
        UUID entityId = event.getEntityId();
        Status entityStatus = statusQueryService.getStatus(entityId);
        entityStatus.getEffects().forEach(effect -> effect.onEntityDamageEvent(event));
    }

    @Subscribe
    public void onEntityHealthChangedEvent(EntityHealthChangedEvent event) {
        UUID entityId = event.getEntityId();
        Status entityStatus = statusQueryService.getStatus(entityId);
        entityStatus.getEffects().forEach(effect -> effect.onEntityHealthChangedEvent(event));
    }

    @Subscribe
    public void onEntityPreFatalDamageEvent(EntityPreFatalDamageEvent event) {
        UUID entityId = event.getEntityId();
        Status entityStatus = statusQueryService.getStatus(entityId);
        entityStatus.getEffects().forEach(effect -> effect.onEntityPreFatalDamageEvent(event));
    }

    @Subscribe
    public void onEntityDeathEvent(EntityDeathEvent event) {
        UUID entityId = event.getEntityId();
        Status entityStatus = statusQueryService.getStatus(entityId);
        entityStatus.getEffects().forEach(effect -> effect.onEntityDeathEvent(event));

        if (playerQueryService.getPlayer(entityId) == null) {
            statusRepository.delete(entityId);
        }
    }

    @Subscribe
    public void onPlayerDisconnectEvent(PlayerDisconnectEvent event) {
        statusRepository.delete(event.getPlayerId());
    }
}
