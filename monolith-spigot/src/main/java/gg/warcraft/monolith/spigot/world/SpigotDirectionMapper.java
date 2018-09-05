package gg.warcraft.monolith.spigot.world;

import gg.warcraft.monolith.api.world.Direction;

public class SpigotDirectionMapper {

    public org.bukkit.block.BlockFace map(Direction direction) {
        switch (direction) {
            case NORTH:
                return org.bukkit.block.BlockFace.NORTH;
            case EAST:
                return org.bukkit.block.BlockFace.EAST;
            case SOUTH:
                return org.bukkit.block.BlockFace.SOUTH;
            case WEST:
                return org.bukkit.block.BlockFace.WEST;
            case UP:
                return org.bukkit.block.BlockFace.UP;
            case DOWN:
                return org.bukkit.block.BlockFace.DOWN;
            default:
                return org.bukkit.block.BlockFace.NORTH;
        }
    }

    public Direction map(org.bukkit.block.BlockFace direction) {
        switch (direction) {
            case NORTH:
                return Direction.NORTH;
            case EAST:
                return Direction.EAST;
            case SOUTH:
                return Direction.SOUTH;
            case WEST:
                return Direction.WEST;
            case UP:
                return Direction.UP;
            case DOWN:
                return Direction.DOWN;
            default:
                return Direction.NORTH;
        }
    }
}
