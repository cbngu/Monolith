package gg.warcraft.monolith.api.config;

import java.io.IOException;

/**
 * This service is injectable.
 * <p>
 * The configuration service serves as a point of entry into the configuration implementation. It allows for retrieving
 * as well as reloading of any server configuration.
 */
public interface ConfigurationService {

    /**
     * Returns the configuration object associated with the specified class.
     *
     * @param configurationClass The class of the configuration object.
     * @param <T>                The type of the configuration class.
     * @return The configuration object. Can be null.
     */
    <T extends Configuration> T getConfiguration(Class<T> configurationClass);

    /**
     * Reloads the configuration associated with the specified class and maps it to an instance of said class.
     *
     * @param configurationFileName The file name of the configuration.
     * @param configurationClass    The class of the configuration object.
     * @param <T>                   The type of the configuration class.
     * @throws IOException Thrown if either the retrieval of the configuration file or the mapping to the configuration
     *                     object failed.
     */
    <T extends Configuration> void reloadConfiguration(String configurationFileName, Class<T> configurationClass)
            throws IOException;
}
