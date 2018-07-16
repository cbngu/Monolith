package gg.warcraft.monolith.app.config.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import gg.warcraft.monolith.api.config.service.ConfigurationRepository;
import gg.warcraft.monolith.api.core.JsonMapper;
import gg.warcraft.monolith.api.core.PersistenceService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class DefaultConfigurationRepository implements ConfigurationRepository {
    private static final String KEY_PREFIX = "configuration:";

    private final PersistenceService persistenceService;
    private final ObjectMapper jsonMapper;
    private final Map<Class<?>, Object> configurationObjects;

    @Inject
    public DefaultConfigurationRepository(PersistenceService persistenceService, @JsonMapper ObjectMapper jsonMapper) {
        this.persistenceService = persistenceService;
        this.jsonMapper = jsonMapper;
        this.configurationObjects = new HashMap<>();
    }

    @Override
    public <T> T getConfiguration(Class<T> configurationClass) {
        Object configuration = configurationObjects.computeIfAbsent(configurationClass, key -> {
            String dataKey = getDataKey(configurationClass);
            String asJson = persistenceService.get(dataKey);
            try {
                return asJson == null ? null : jsonMapper.readValue(asJson, configurationClass);
            } catch (IOException ex) {
                throw new IllegalStateException("Failed to parse JSON for " + configurationClass + ": " + ex.getMessage());
            }
        });
        return configurationClass.cast(configuration);
    }

    private String getDataKey(Class configurationClass) {
        return KEY_PREFIX + configurationClass.getSimpleName();
    }

    @Override
    public void save(Object configurationObject) {
        configurationObjects.put(configurationObject.getClass(), configurationObject);

        String dataKey = getDataKey(configurationObject.getClass());
        try {
            String asJson = jsonMapper.writeValueAsString(configurationObject);
            persistenceService.set(dataKey, asJson);
        } catch (JsonProcessingException ex) {
            throw new IllegalStateException("Failed to write JSON for " + configurationObject.getClass() + ": " + ex.getMessage());
        }
    }
}
