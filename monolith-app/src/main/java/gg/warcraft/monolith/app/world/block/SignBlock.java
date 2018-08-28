package gg.warcraft.monolith.app.world.block;

import gg.warcraft.monolith.api.world.block.Block;
import gg.warcraft.monolith.api.world.block.BlockType;
import gg.warcraft.monolith.api.world.block.Sign;
import gg.warcraft.monolith.api.world.location.BlockLocation;

import java.util.Arrays;

public class SignBlock extends SimpleBlock implements Sign {
    private final String[] lines;
    private final Block attachedTo;

    public SignBlock(BlockType type, BlockLocation location, String[] lines, Block attachedTo) {
        super(type, location);
        this.lines = lines;
        this.attachedTo = attachedTo;
    }

    @Override
    public String[] getLines() {
        return Arrays.copyOf(lines, lines.length);
    }

    @Override
    public Block getAttachedTo() {
        return attachedTo;
    }
}
