package gg.warcraft.monolith.app.world.chunk.events;

import gg.warcraft.monolith.api.world.chunk.event.AbstractChunkEvent;
import gg.warcraft.monolith.api.world.chunk.event.ChunkLoadedEvent;

public class SimpleChunkLoadedEvent extends AbstractChunkEvent implements ChunkLoadedEvent {

    public SimpleChunkLoadedEvent(int x, int z) {
        super(x, z);
    }
}
