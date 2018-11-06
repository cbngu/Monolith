package gg.warcraft.monolith.api.world.chunk.event;

import gg.warcraft.monolith.api.core.Event;

public interface ChunkEvent extends Event {

    int getX();

    int getZ();
}
