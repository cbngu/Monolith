package gg.warcraft.monolith.api.world.block.event;

import java.util.UUID;

public interface BlockPreTriggerEvent extends BlockPreEvent {

    UUID getPlayerId();
}
