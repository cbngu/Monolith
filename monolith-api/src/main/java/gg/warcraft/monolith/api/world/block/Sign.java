package gg.warcraft.monolith.api.world.block;

public interface Sign extends Block {

    /**
     * @return A copy of the lines on the sign. This array will always have a length of 4. Never null or empty. Items
     * are never null, but can be empty.
     */
    String[] getLines();

    /**
     * @return The block this sign is attached to. For wall mounted signs this will be the block the sign is mounted on.
     * For ground placed signs this will be the block the sign is placed upon.
     */
    Block getAttachedTo();
}
