package gg.warcraft.monolith.api.config.service;

import java.io.IOException;

/**
 * This service is injectable.
 * <p>
 * The ConfigurationCommandService serves as a point of entry into the persistence module implementation. It provides a
 * method to reload a {@code Configuration} and recreate the object that its mapped to.
 */
public interface ConfigurationCommandService {

    void reloadConfiguration(String configurationFileName) throws IOException;
}
