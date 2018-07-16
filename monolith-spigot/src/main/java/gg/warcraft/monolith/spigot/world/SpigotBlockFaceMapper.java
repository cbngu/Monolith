package gg.warcraft.monolith.spigot.world;

import gg.warcraft.monolith.api.world.Direction;
import gg.warcraft.monolith.api.world.block.BlockFace;

public class SpigotBlockFaceMapper {

    public org.bukkit.block.BlockFace map(BlockFace face) {
        switch (face) {
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

    public BlockFace map(org.bukkit.block.BlockFace face) {
        switch (face) {
            case NORTH:
                return BlockFace.NORTH;
            case EAST:
                return BlockFace.EAST;
            case SOUTH:
                return BlockFace.SOUTH;
            case WEST:
                return BlockFace.WEST;
            case UP:
                return BlockFace.UP;
            case DOWN:
                return BlockFace.DOWN;
            default:
                return BlockFace.NORTH;
        }
    }

    public Direction mapDirection(org.bukkit.block.BlockFace face) {
        switch (face) {
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
