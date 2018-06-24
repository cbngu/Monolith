package gg.warcraft.monolith.app.config.service;

import gg.warcraft.monolith.api.config.Configuration;
import gg.warcraft.monolith.api.config.service.ConfigurationCommandService;

public class LocalConfigurationCommandService implements ConfigurationCommandService {

    @Override
    public void reloadConfiguration(Configuration configuration) {
        // do nothing
    }
}
