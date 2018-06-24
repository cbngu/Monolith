package gg.warcraft.monolith.api.config.service;

/**
 * This service is injectable.
 * <p>
 * The ConfigurationQueryService serves as a point of entry into the persistence implementation. It provides a method to
 * query a currently loaded {@code Configuration} by mapped class to retrieve it as that class.
 */
public interface ConfigurationQueryService {

    /**
     * Returns the configuration object for the given class. This will return null if no configuration for this class
     * has been loaded.
     *
     * @param configurationClass The class of the configuration object. Can not be null.
     * @param <T>                The type of the configuration class. Can not be null.
     * @return The configuration object. Can be null.
     */
    <T> T getConfiguration(Class<T> configurationClass);
}
