package gg.warcraft.monolith.app.config.service;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.config.service.ConfigurationQueryService;
import gg.warcraft.monolith.api.config.service.ConfigurationRepository;

public class DefaultConfigurationQueryService implements ConfigurationQueryService {
    private final ConfigurationRepository repository;

    @Inject
    public DefaultConfigurationQueryService(ConfigurationRepository repository) {
        this.repository = repository;
    }

    @Override
    public String getConfiguration(String configurationFileName) {
        return repository.getConfiguration(configurationFileName);
    }
}
