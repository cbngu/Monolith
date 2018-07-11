package gg.warcraft.monolith.api.world.block.event;

import java.util.UUID;

public interface BlockTriggerEvent extends BlockEvent {

    UUID getPlayerId();
}
