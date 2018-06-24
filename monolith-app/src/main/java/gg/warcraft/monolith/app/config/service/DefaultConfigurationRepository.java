package gg.warcraft.monolith.app.config.service;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import gg.warcraft.monolith.api.config.service.ConfigurationRepository;
import gg.warcraft.monolith.api.persistence.JsonMapper;
import gg.warcraft.monolith.api.persistence.PersistenceService;

import java.util.HashMap;
import java.util.Map;

@Singleton
public class DefaultConfigurationRepository implements ConfigurationRepository {
    private static final String KEY_PREFIX = "configuration:";

    private final PersistenceService persistenceService;
    private final JsonMapper jsonMapper;
    private final Map<Class<?>, Object> configurationObjects;

    @Inject
    public DefaultConfigurationRepository(PersistenceService persistenceService, JsonMapper jsonMapper) {
        this.persistenceService = persistenceService;
        this.jsonMapper = jsonMapper;
        this.configurationObjects = new HashMap<>();
    }

    @Override
    public <T> T getConfiguration(Class<T> configurationClass) {
        Object configuration = configurationObjects.computeIfAbsent(configurationClass, key -> {
            String dataKey = getDataKey(configurationClass);
            String asJson = persistenceService.get(dataKey);
            return asJson == null ? null : jsonMapper.parse(asJson, configurationClass);
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
        String asJson = jsonMapper.stringify(configurationObject);
        persistenceService.set(dataKey, asJson);
    }
}
