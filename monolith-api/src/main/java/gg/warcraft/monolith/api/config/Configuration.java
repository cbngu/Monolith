package gg.warcraft.monolith.api.config;

/**
 * A Configuration is an object representation of a configuration file.
 */
public interface Configuration {

    /**
     * Returns the file name of this configuration.
     *
     * @return The file name of this configuration. Never null or empty.
     */
    String getFileName();
}
