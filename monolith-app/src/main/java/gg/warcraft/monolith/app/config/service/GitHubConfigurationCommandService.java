package gg.warcraft.monolith.app.config.service;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import gg.warcraft.monolith.api.config.service.ConfigurationCommandService;
import gg.warcraft.monolith.api.config.service.ConfigurationRepository;
import org.kohsuke.github.GHContent;
import org.kohsuke.github.GHOrganization;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class GitHubConfigurationCommandService implements ConfigurationCommandService {
    private final ConfigurationRepository configurationRepository;
    private final String accountName;
    private final String repositoryName;

    @Inject
    public GitHubConfigurationCommandService(ConfigurationRepository configurationRepository,
                                             @Named("GitHubAccount") String accountName,
                                             @Named("GitHubRepository") String repositoryName) {
        this.configurationRepository = configurationRepository;
        this.accountName = accountName;
        this.repositoryName = repositoryName;
    }

    GHRepository connectToRepository() throws IOException {
        GitHub github = GitHub.connectAnonymously();
        GHOrganization account = github.getOrganization(accountName);
        return account.getRepository(repositoryName);
    }

    @Override
    public void reloadConfiguration(String configurationFileName) throws IOException {
        GHRepository gitHubRepository = connectToRepository();
        GHContent content = gitHubRepository.getFileContent(configurationFileName);
        try (InputStream inputStream = content.read();
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            String configuration = bufferedReader.lines().collect(Collectors.joining("\n"));
            configurationRepository.save(configurationFileName, configuration);
        }
    }
}
