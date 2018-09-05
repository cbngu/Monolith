package gg.warcraft.monolith.api.world;

import org.joml.Vector3f;

public interface DirectionUtils {

    Direction getOpposite(Direction direction);

    int getRotation(Direction from, Direction to);

    Vector3f toVector(Direction direction);
}
