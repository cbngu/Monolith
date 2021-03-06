package gg.warcraft.monolith.api.world.block;

import gg.warcraft.monolith.api.world.location.Location;

import java.util.Iterator;

public interface BlockIterator extends Iterator<Block> {

    /**
     * @return The location where the block last retrieved from the iterator was intersected. Never null.
     */
    Location calculateIntersection();
}
