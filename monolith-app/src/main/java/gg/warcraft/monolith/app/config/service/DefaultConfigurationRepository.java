package gg.warcraft.monolith.app.config.service;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import gg.warcraft.monolith.api.config.service.ConfigurationRepository;
import gg.warcraft.monolith.api.core.PersistenceService;

@Singleton
public class DefaultConfigurationRepository implements ConfigurationRepository {
    private static final String KEY_PREFIX = "configuration:";

    private final PersistenceService persistenceService;

    @Inject
    public DefaultConfigurationRepository(PersistenceService persistenceService) {
        this.persistenceService = persistenceService;
    }

    private String getDataKey(String configurationFileName) {
        return KEY_PREFIX + configurationFileName;
    }

    @Override
    public String getConfiguration(String configurationFileName) {
        String dataKey = getDataKey(configurationFileName);
        return persistenceService.get(dataKey);
    }

    @Override
    public void save(String configurationFileName, String configuration) {
        String dataKey = getDataKey(configurationFileName);
        persistenceService.set(dataKey, configuration);
    }
}
