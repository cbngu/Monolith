package gg.warcraft.monolith.app.entity.status.handler;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import gg.warcraft.monolith.api.entity.event.EntityDamageEvent;
import gg.warcraft.monolith.api.entity.event.EntityDeathEvent;
import gg.warcraft.monolith.api.entity.event.EntityHealthChangedEvent;
import gg.warcraft.monolith.api.entity.event.EntityPreDamageEvent;
import gg.warcraft.monolith.api.entity.event.EntityPreFatalDamageEvent;
import gg.warcraft.monolith.api.entity.status.Status;
import gg.warcraft.monolith.api.entity.status.service.StatusQueryService;

import java.util.UUID;

public class StatusEffectHandler {
    private final StatusQueryService statusQueryService;

    @Inject
    public StatusEffectHandler(StatusQueryService statusQueryService) {
        this.statusQueryService = statusQueryService;
    }

    @Subscribe
    public void onEntityPreDamageEvent(EntityPreDamageEvent event) {
        UUID casterId = event.getEntityId();
        Status casterStatus = statusQueryService.getStatus(casterId);
        casterStatus.getEffects().forEach(effect -> effect.onEntityPreDamageEvent(event));
    }

    @Subscribe
    public void onEntityDamageEvent(EntityDamageEvent event) {
        UUID casterId = event.getEntityId();
        Status casterStatus = statusQueryService.getStatus(casterId);
        casterStatus.getEffects().forEach(effect -> effect.onEntityDamageEvent(event));
    }

    @Subscribe
    public void onEntityHealthChangedEvent(EntityHealthChangedEvent event) {
        UUID casterId = event.getEntityId();
        Status casterStatus = statusQueryService.getStatus(casterId);
        casterStatus.getEffects().forEach(effect -> effect.onEntityHealthChangedEvent(event));
    }

    @Subscribe
    public void onEntityPreFatalDamageEvent(EntityPreFatalDamageEvent event) {
        UUID casterId = event.getEntityId();
        Status casterStatus = statusQueryService.getStatus(casterId);
        casterStatus.getEffects().forEach(effect -> effect.onEntityPreFatalDamageEvent(event));
    }

    @Subscribe
    public void onEntityDeathEvent(EntityDeathEvent event) {
        UUID casterId = event.getEntityId();
        Status casterStatus = statusQueryService.getStatus(casterId);
        casterStatus.getEffects().forEach(effect -> effect.onEntityDeathEvent(event));
    }
}
