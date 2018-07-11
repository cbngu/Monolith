package gg.warcraft.monolith.api.world;

public interface DirectionUtils {

    Direction getOpposite(Direction direction);

    int getRotation(Direction from, Direction to);
}
