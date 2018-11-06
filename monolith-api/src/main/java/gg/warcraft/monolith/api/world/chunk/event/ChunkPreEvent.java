package gg.warcraft.monolith.api.world.chunk.event;

import gg.warcraft.monolith.api.core.PreEvent;

public interface ChunkPreEvent extends PreEvent {

    int getX();

    int getZ();
}
