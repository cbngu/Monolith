package gg.warcraft.monolith.spigot;

public class MonolithConfiguration {
    private final boolean firstTimeSetup;
    private final String configurationService;
    private final String gitHubAccount;
    private final String gitHubRepository;
    private final String persistenceService;
    private final String redisHost;
    private final int redisPort;

    public MonolithConfiguration() {
        this.firstTimeSetup = true;
        this.configurationService = "LOCAL";
        this.gitHubAccount = "AccountName";
        this.gitHubRepository = "RepositoryName";
        this.persistenceService = "REDIS";
        this.redisHost = "127.0.0.1";
        this.redisPort = 6379;
    }
}
