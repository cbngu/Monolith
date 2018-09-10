package gg.warcraft.monolith.api.config.service;

/**
 * This repository is injectable, however you generally have no need for it. Use the command and query services instead.
 * <p>
 * If you feel you absolutely have to use this repository it can be used to forgo the command service and save a
 * configurations to the Monolith domain directly. This repository does no safety checks whatsoever.
 */
public interface ConfigurationRepository {

    String getConfiguration(String configurationFileName);

    void save(String configurationFileName, String configuration);
}
