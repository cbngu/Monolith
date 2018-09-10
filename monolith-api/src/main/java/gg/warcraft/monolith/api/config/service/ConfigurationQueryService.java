package gg.warcraft.monolith.api.config.service;

/**
 * This service is injectable.
 * <p>
 * The ConfigurationQueryService serves as a point of entry into the persistence implementation. It provides a method to
 * query a currently loaded {@code Configuration} by mapped class to retrieve it as that class.
 */
public interface ConfigurationQueryService {

    String getConfiguration(String configurationFileName);
}
