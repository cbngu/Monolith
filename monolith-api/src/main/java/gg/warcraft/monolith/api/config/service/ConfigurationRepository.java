package gg.warcraft.monolith.api.config.service;

/**
 * This repository is injectable, however you generally have no need for it. Use the command and query services instead.
 * <p>
 * If you feel you absolutely have to use this repository it can be used to forgo the command service and save a mapped
 * configurations to the Monolith domain directly. This repository does no safety checks whatsoever.
 */
public interface ConfigurationRepository {

    /**
     * @param configurationClass The class of the configuration object. Can not be null.
     * @param <T>                The type of the configuration class. Can not be null.
     * @return The configuration object. Can be null.
     */
    <T> T getConfiguration(Class<T> configurationClass);

    /**
     * @param configurationObject The configuration object to save. Can not be null.
     */
    void save(Object configurationObject);
}
