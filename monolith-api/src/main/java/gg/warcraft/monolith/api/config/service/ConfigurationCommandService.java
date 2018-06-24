package gg.warcraft.monolith.api.config.service;

import java.io.IOException;

/**
 * This service is injectable.
 * <p>
 * The ConfigurationCommandService serves as a point of entry into the persistence module implementation. It provides a
 * method to reload a {@code Configuration} and recreate the object that its mapped to.
 */
public interface ConfigurationCommandService {

    /**
     * @param configurationFileName The name of the configuration file to reload. Can not be null or empty.
     * @param configurationClass    The class of the configuration object. Can not be null.
     * @throws IOException Thrown if either the retrieval of the configuration file or the mapping to the configuration
     *                     class failed.
     */
    void reloadConfiguration(String configurationFileName, Class<?> configurationClass) throws IOException;
}
