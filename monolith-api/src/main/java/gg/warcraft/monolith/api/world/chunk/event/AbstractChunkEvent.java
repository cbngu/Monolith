package gg.warcraft.monolith.api.world.chunk.event;

public abstract class AbstractChunkEvent implements ChunkEvent {
    private final int x;
    private final int z;

    public AbstractChunkEvent(int x, int z) {
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
