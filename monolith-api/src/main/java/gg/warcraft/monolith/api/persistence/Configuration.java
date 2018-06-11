package gg.warcraft.monolith.api.persistence;

/**
 * A Configuration holds metadata about a configuration file hosted elsewhere, whether on the file system of
 * the server or a cloud based repository such as GitHub.
 */
public interface Configuration {

    /**
     * @return The file name of this configuration. Never null or empty.
     */
    String getFileName();

    /**
     * @return The class this configuration can be mapped to. Never null.
     */
    Class<?> getConfigurationClass();
}
