package gg.warcraft.monolith.app.world.block.build;

import gg.warcraft.monolith.api.world.block.BoundingBlockBox;
import gg.warcraft.monolith.api.world.block.build.BlockBuild;

public class SimpleBlockBuild implements BlockBuild {
    private final String type;
    private final String model;
    private final BoundingBlockBox boundingBox;

    public SimpleBlockBuild(String type, String model, BoundingBlockBox boundingBox) {
        this.type = type;
        this.model = model;
        this.boundingBox = boundingBox;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public BoundingBlockBox getBoundingBox() {
        return boundingBox;
    }
}
