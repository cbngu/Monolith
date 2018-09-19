package gg.warcraft.monolith.api.world;

import org.joml.Vector3f;

public interface DirectionUtils {

    Direction getOpposite(Direction direction);

    int getRotation(Direction from, Direction to);

    Direction rotate(Direction direction, int rotation);

    Direction toDirection(float yaw);

    Vector3f toVector(Direction direction);
}
