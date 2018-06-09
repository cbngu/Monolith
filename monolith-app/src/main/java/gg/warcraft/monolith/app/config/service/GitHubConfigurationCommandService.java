package gg.warcraft.monolith.app.config.service;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import gg.warcraft.monolith.api.config.Configuration;
import gg.warcraft.monolith.api.config.JsonMapper;
import gg.warcraft.monolith.api.config.Mapper;
import gg.warcraft.monolith.api.config.YamlMapper;
import gg.warcraft.monolith.api.config.service.ConfigurationCommandService;
import gg.warcraft.monolith.api.config.service.ConfigurationRepository;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.IOException;
import java.io.InputStreamReader;

// TODO: save configuration files locally as github can time-out anon requests over 10 per hour
public class GitHubConfigurationCommandService implements ConfigurationCommandService {
    private final ConfigurationRepository configurationRepository;
    private final YamlMapper yamlMapper;
    private final JsonMapper jsonMapper;
    private final String accountName;
    private final String repositoryName;

    @Inject
    public GitHubConfigurationCommandService(ConfigurationRepository configurationRepository, YamlMapper yamlMapper,
                                             JsonMapper jsonMapper, @Named("GitHubAccount") String accountName,
                                             @Named("GitHubRepository") String repositoryName) {
        this.configurationRepository = configurationRepository;
        this.yamlMapper = yamlMapper;
        this.jsonMapper = jsonMapper;
        this.accountName = accountName;
        this.repositoryName = repositoryName;
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
        var github = GitHub.connectAnonymously();
        var account = github.getOrganization(accountName);
        return account.getRepository(repositoryName);
    }

    @Override
    public void reloadConfiguration(Configuration configuration) throws IOException {
        var fileName = configuration.getFileName();
        var mapper = getMapperFor(fileName);
        var gitHubRepository = connectToRepository();
        var content = gitHubRepository.getFileContent(fileName);

        var configurationClass = configuration.getConfigurationClass();
        try (InputStreamReader reader = new InputStreamReader(content.read())) {
            var configurationObject = mapper.parse(reader, configurationClass);
            configurationRepository.save(configurationObject);
        }
    }
}
