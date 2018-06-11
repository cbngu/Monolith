package gg.warcraft.monolith.app.persistence.service;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.persistence.service.ConfigurationQueryService;
import gg.warcraft.monolith.api.persistence.service.ConfigurationRepository;

public class DefaultConfigurationQueryService implements ConfigurationQueryService {
    private final ConfigurationRepository repository;

    @Inject
    public DefaultConfigurationQueryService(ConfigurationRepository repository) {
        this.repository = repository;
    }

    @Override
    public <T> T getConfiguration(Class<T> configurationClass) {
        return repository.getConfiguration(configurationClass);
    }
}
