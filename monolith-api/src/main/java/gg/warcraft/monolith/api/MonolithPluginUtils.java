package gg.warcraft.monolith.api;

import com.fasterxml.jackson.databind.module.SimpleModule;

public interface MonolithPluginUtils {

    <T> T loadLocalConfiguration(String configurationYaml, Class<T> configurationClass);

    <T> T loadRemoteConfiguration(String configurationFileName, Class<T> configurationClass);

    <T> T loadConfiguration(String configurationType, String configurationFileName, String configurationYaml,
                            Class<T> configurationClass, SimpleModule... extraMapperModules);
}
