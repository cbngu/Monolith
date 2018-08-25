package gg.warcraft.monolith.app.world.block.build;

import gg.warcraft.monolith.api.world.block.box.BoundingBlockBox;
import gg.warcraft.monolith.api.world.block.build.AbstractBlockBuild;

public class SimpleBlockBuild extends AbstractBlockBuild {

    public SimpleBlockBuild(String type, String model, String[] data, BoundingBlockBox boundingBox) {
        super(type, model, data, boundingBox);
    }
}
