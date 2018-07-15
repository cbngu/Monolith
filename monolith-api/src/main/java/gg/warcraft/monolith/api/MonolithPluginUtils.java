package gg.warcraft.monolith.api;

public interface MonolithPluginUtils {

    <T> T loadLocalConfiguration(String configurationYaml, Class<T> configurationClass);

    <T> T loadRemoteConfiguration(String configurationFileName, Class<T> configurationClass);

    <T> T loadConfiguration(String configurationType, String configurationFileName, String configurationYaml,
                            Class<T> configurationClass);
}
