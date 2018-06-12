package gg.warcraft.monolith.app.persistence.service;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import gg.warcraft.monolith.api.persistence.Configuration;
import gg.warcraft.monolith.api.persistence.JsonMapper;
import gg.warcraft.monolith.api.persistence.Mapper;
import gg.warcraft.monolith.api.persistence.YamlMapper;
import gg.warcraft.monolith.api.persistence.service.ConfigurationCommandService;
import gg.warcraft.monolith.api.persistence.service.ConfigurationRepository;
import org.kohsuke.github.GHContent;
import org.kohsuke.github.GHOrganization;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.IOException;
import java.io.InputStreamReader;

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
            int dotIndex = fileName.lastIndexOf('.');
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
    public void reloadConfiguration(Configuration configuration) throws IOException {
        String fileName = configuration.getFileName();
        Mapper mapper = getMapperFor(fileName);
        GHRepository gitHubRepository = connectToRepository();
        GHContent content = gitHubRepository.getFileContent(fileName);

        Class<?> configurationClass = configuration.getConfigurationClass();
        try (InputStreamReader reader = new InputStreamReader(content.read())) {
            Object configurationObject = mapper.parse(reader, configurationClass);
            configurationRepository.save(configurationObject);
        }
    }
}
