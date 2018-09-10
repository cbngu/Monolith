package gg.warcraft.monolith.app.config.service;

import gg.warcraft.monolith.api.config.service.ConfigurationCommandService;

import java.io.IOException;

public class LocalConfigurationCommandService implements ConfigurationCommandService {

    @Override
    public void reloadConfiguration(String configurationFileName) throws IOException {
        // do nothing
    }
}
