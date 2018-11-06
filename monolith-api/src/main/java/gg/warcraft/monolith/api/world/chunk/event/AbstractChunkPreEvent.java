package gg.warcraft.monolith.api.world.chunk.event;

import gg.warcraft.monolith.api.core.event.AbstractPreEvent;

public abstract class AbstractChunkPreEvent extends AbstractPreEvent implements ChunkPreEvent {
    private final int x;
    private final int z;

    public AbstractChunkPreEvent(int x, int z, boolean cancelled) {
        super(cancelled);
        this.x = x;
        this.z = z;
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getZ() {
        return 0;
    }
}
