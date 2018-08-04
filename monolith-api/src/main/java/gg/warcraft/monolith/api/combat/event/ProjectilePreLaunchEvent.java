package gg.warcraft.monolith.api.combat.event;

import java.util.UUID;

public interface ProjectilePreLaunchEvent extends ProjectilePreEvent {

    UUID getShooterId();
}
