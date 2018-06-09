package gg.warcraft.monolith.app.config.service;

import gg.warcraft.monolith.api.config.service.ConfigurationRepository;

import java.util.HashMap;
import java.util.Map;

public class DefaultConfigurationRepository implements ConfigurationRepository {
    private final Map<Class<?>, Object> configurationObjects;

    public DefaultConfigurationRepository() {
        this.configurationObjects = new HashMap<>();
    }

    @Override
    public <T> T getConfiguration(Class<T> configurationClass) {
        return configurationClass.cast(configurationObjects.get(configurationClass));
    }

    @Override
    public void save(Object configurationObject) {
        configurationObjects.put(configurationObject.getClass(), configurationObject);
    }
}
