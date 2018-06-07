package gg.warcraft.monolith.app.config;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import gg.warcraft.monolith.api.config.Configuration;
import gg.warcraft.monolith.api.config.ConfigurationService;
import gg.warcraft.monolith.api.config.JsonMapper;
import gg.warcraft.monolith.api.config.Mapper;
import gg.warcraft.monolith.api.config.YamlMapper;
import org.kohsuke.github.GHOrganization;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// TODO: configuration files should be saved locally as github can time-out anon requests over 10 per hour
public class GitHubConfigurationService implements ConfigurationService {
    private final YamlMapper yamlMapper;
    private final JsonMapper jsonMapper;
    private final String accountName;
    private final String repositoryName;
    private final Map<Class<? extends Configuration>, Configuration> configurations;

    @Inject
    public GitHubConfigurationService(YamlMapper yamlMapper, JsonMapper jsonMapper,
                                      @Named("GitHubAccount") String accountName,
                                      @Named("GitHubRepository") String repositoryName) {
        this.yamlMapper = yamlMapper;
        this.jsonMapper = jsonMapper;
        this.accountName = accountName;
        this.repositoryName = repositoryName;
        this.configurations = new HashMap<>();
    }

    @Override
    public <T extends Configuration> T getConfiguration(Class<T> configurationClass) {
        var configuration = configurations.get(configurationClass);
        return configurationClass.cast(configuration);
    }

    Mapper getMapperFor(String fileName) {
        if (fileName.endsWith(".yml")) {
            return yamlMapper;
        } else if (fileName.endsWith(".json")) {
            return jsonMapper;
        } else {
            var dotIndex = fileName.lastIndexOf('.');
            throw new IllegalArgumentException(
                    "Unsupported configuration file extension: " + fileName.substring(dotIndex));
        }
    }

    GHRepository connectToRepository() throws IOException {
        GitHub github = GitHub.connectAnonymously();
        GHOrganization account = github.getOrganization(accountName);
        return account.getRepository(repositoryName);
    }

    @Override
    public <T extends Configuration> void reloadConfiguration(String configurationFileName,
                                                              Class<T> configurationClass) throws IOException {
        var mapper = getMapperFor(configurationFileName);
        var repository = connectToRepository();
        var content = repository.getFileContent(configurationFileName);

        T configuration;
        try (InputStreamReader reader = new InputStreamReader(content.read())) {
            configuration = mapper.from(reader, configurationClass);
        }
        configurations.put(configurationClass, configuration);
    }
}
