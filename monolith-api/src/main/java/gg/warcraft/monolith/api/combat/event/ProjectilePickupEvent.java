package gg.warcraft.monolith.api.combat.event;

import java.util.UUID;

public interface ProjectilePickupEvent extends ProjectileEvent {

    UUID getPickupEntityId();
}
