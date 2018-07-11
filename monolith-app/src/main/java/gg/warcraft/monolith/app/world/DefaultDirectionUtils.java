package gg.warcraft.monolith.app.world;

import gg.warcraft.monolith.api.world.Direction;
import gg.warcraft.monolith.api.world.DirectionUtils;

public class DefaultDirectionUtils implements DirectionUtils {

    @Override
    public Direction getOpposite(Direction direction) {
        switch (direction) {
            case NORTH:
                return Direction.SOUTH;
            case EAST:
                return Direction.WEST;
            case SOUTH:
                return Direction.NORTH;
            case WEST:
                return Direction.EAST;
            case UP:
                return Direction.DOWN;
            case DOWN:
                return Direction.UP;
            default:
                throw new IllegalArgumentException("Failed to return opposite direction for " + direction);
        }
    }

    @Override
    public int getRotation(Direction from, Direction to) {
        if (from == Direction.UP || from == Direction.DOWN ||
                to == Direction.UP || to == Direction.DOWN) {
            throw new IllegalArgumentException("Failed to return rotation from " + from + " to " + to);
        }
        int fromOrdinal = from.ordinal();
        int toOrdinal = to.ordinal();
        int ordinalDiff = toOrdinal - fromOrdinal;
        while (ordinalDiff < 0) {
            ordinalDiff += 4;
        }
        return ordinalDiff * 90;
    }
}
