package gg.warcraft.monolith.api.world.service;

import gg.warcraft.monolith.api.item.Item;
import gg.warcraft.monolith.api.world.Location;
import gg.warcraft.monolith.api.world.Sound;
import gg.warcraft.monolith.api.world.SoundCategory;
import gg.warcraft.monolith.api.world.block.Block;
import gg.warcraft.monolith.api.world.block.BlockType;
import gg.warcraft.monolith.api.world.block.Sign;
import org.joml.Vector3f;

import java.util.List;
import java.util.UUID;

/**
 * This service is injectable.
 * <p>
 * The WorldCommandService serves as a point of entry into the world module implementation. It allows for easy updating
 * of block types and dropping items at a location.
 */
public interface WorldCommandService {

    /**
     * @param block The block to update.
     * @param type  The new type.
     */
    void setBlockType(Block block, BlockType type);

    /**
     * @param sign  The sign to update.
     * @param lines The new lines.
     */
    void setSignLines(Sign sign, String[] lines);

    /**
     * @param items    The items to drop.
     * @param location The location to drop at.
     */
    void dropItemsAt(List<Item> items, Location location);

    void playSound(Location location, Sound sound, SoundCategory category, float volume, float pitch);

    void strikeLightning(Location location, boolean ambient);

    UUID createArrow(UUID shooterId, Location location, Vector3f direction, float speed, float spread);
}
