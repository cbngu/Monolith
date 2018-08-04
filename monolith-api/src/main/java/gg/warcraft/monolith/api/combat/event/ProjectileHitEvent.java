package gg.warcraft.monolith.api.combat.event;

import gg.warcraft.monolith.api.world.block.Block;

import java.util.UUID;

public interface ProjectileHitEvent extends ProjectileEvent {

    Block getBlock();

    UUID getEntityId();
}
