package gg.warcraft.monolith.api.combat.event;

import java.util.UUID;

public interface ProjectileLaunchEvent extends ProjectileEvent {

    UUID getShooterId();
}
