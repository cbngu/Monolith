package gg.warcraft.monolith.app.world.chunk.events;

import gg.warcraft.monolith.api.world.chunk.event.AbstractChunkPreEvent;
import gg.warcraft.monolith.api.world.chunk.event.ChunkPreUnloadEvent;

public class SimpleChunkPreUnloadEvent extends AbstractChunkPreEvent implements ChunkPreUnloadEvent {

    public SimpleChunkPreUnloadEvent(int x, int z, boolean cancelled) {
        super(x, z, cancelled);
    }
}
