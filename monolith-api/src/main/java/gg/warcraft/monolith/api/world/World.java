package gg.warcraft.monolith.api.world;

/**
 * The World interface serves as an abstraction layer between Monolith plugin code and the eventual server
 * implementation the plugin is run on.
 */
public interface World {

    /**
     * @return The type of this world.
     */
    WorldType getType();
}
