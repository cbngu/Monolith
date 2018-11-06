package gg.warcraft.monolith.app.world.chunk.events;

import gg.warcraft.monolith.api.world.chunk.event.AbstractChunkEvent;
import gg.warcraft.monolith.api.world.chunk.event.ChunkUnloadedEvent;

public class SimpleChunkUnloadedEvent extends AbstractChunkEvent implements ChunkUnloadedEvent {

    public SimpleChunkUnloadedEvent(int x, int z) {
        super(x, z);
    }
}
