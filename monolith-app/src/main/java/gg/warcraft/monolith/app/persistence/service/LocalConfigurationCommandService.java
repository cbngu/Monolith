package gg.warcraft.monolith.app.persistence.service;

import gg.warcraft.monolith.api.persistence.Configuration;
import gg.warcraft.monolith.api.persistence.service.ConfigurationCommandService;

public class LocalConfigurationCommandService implements ConfigurationCommandService {

    @Override
    public void reloadConfiguration(Configuration configuration) {
        // do nothing
    }
}
