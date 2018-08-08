package gg.warcraft.monolith.api.combat.event;

import java.util.UUID;

public interface ProjectilePrePickupEvent extends ProjectilePreEvent {

    UUID getPickupEntityId();
}
