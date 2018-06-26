package gg.warcraft.monolith.app.world.block;

import gg.warcraft.monolith.api.world.BlockLocation;
import gg.warcraft.monolith.api.world.block.Block;
import gg.warcraft.monolith.api.world.block.BlockFace;
import gg.warcraft.monolith.api.world.block.BlockType;

import java.util.Objects;

public class SimpleBlock implements Block {
    private final BlockType type;
    private final BlockLocation location;

    public SimpleBlock(BlockType type, BlockLocation location) {
        this.type = type;
        this.location = location;
    }

    @Override
    public BlockType getType() {
        return type;
    }

    @Override
    public BlockLocation getLocation() {
        return location;
    }

    @Override
    public Block getRelative(BlockFace face) {
        return null; // TODO: implement
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Block other = (Block) object;
        return Objects.equals(getType(), other.getType())
                && Objects.equals(getLocation(), other.getLocation());
    }

    @Override
    public int hashCode() {
        String id = getType() + ":" + getLocation();
        return id.hashCode();
    }
}
