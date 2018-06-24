package gg.warcraft.monolith.api.config.service;

import gg.warcraft.monolith.api.config.Configuration;

import java.io.IOException;

/**
 * This service is injectable.
 * <p>
 * The ConfigurationCommandService serves as a point of entry into the persistence module implementation. It provides a
 * method to reload a {@code Configuration} and recreate the object that its mapped to.
 */
public interface ConfigurationCommandService {

    /**
     * @param configuration The configuration to reload. Can not be null.
     * @throws IOException Thrown if either the retrieval of the configuration file or the mapping to the configuration
     *                     class failed.
     */
    void reloadConfiguration(Configuration configuration) throws IOException;
}
