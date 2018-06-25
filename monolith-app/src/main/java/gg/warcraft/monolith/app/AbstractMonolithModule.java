package gg.warcraft.monolith.app;

import com.google.inject.Singleton;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.google.inject.name.Names;
import gg.warcraft.monolith.api.MonolithModule;
import gg.warcraft.monolith.api.command.CommandSender;
import gg.warcraft.monolith.api.command.Console;
import gg.warcraft.monolith.api.command.service.CommandCommandService;
import gg.warcraft.monolith.api.command.service.CommandQueryService;
import gg.warcraft.monolith.api.command.service.CommandRepository;
import gg.warcraft.monolith.api.config.service.ConfigurationCommandService;
import gg.warcraft.monolith.api.config.service.ConfigurationQueryService;
import gg.warcraft.monolith.api.config.service.ConfigurationRepository;
import gg.warcraft.monolith.api.core.EventService;
import gg.warcraft.monolith.api.effect.EffectVectors;
import gg.warcraft.monolith.api.effect.EffectVectorsFactory;
import gg.warcraft.monolith.api.entity.attribute.service.AttributeCommandService;
import gg.warcraft.monolith.api.entity.attribute.service.AttributeQueryService;
import gg.warcraft.monolith.api.entity.attribute.service.AttributeRepository;
import gg.warcraft.monolith.api.entity.status.service.StatusCommandService;
import gg.warcraft.monolith.api.entity.status.service.StatusQueryService;
import gg.warcraft.monolith.api.entity.status.service.StatusRepository;
import gg.warcraft.monolith.api.item.ItemBuilder;
import gg.warcraft.monolith.api.item.ItemBuilderFactory;
import gg.warcraft.monolith.api.item.ItemReader;
import gg.warcraft.monolith.api.item.ItemReaderFactory;
import gg.warcraft.monolith.api.persistence.JsonMapper;
import gg.warcraft.monolith.api.persistence.PersistenceService;
import gg.warcraft.monolith.api.persistence.YamlMapper;
import gg.warcraft.monolith.api.util.MathUtils;
import gg.warcraft.monolith.api.util.StringUtils;
import gg.warcraft.monolith.api.util.TimeUtils;
import gg.warcraft.monolith.api.world.service.WorldQueryService;
import gg.warcraft.monolith.app.command.ConsoleCommandSender;
import gg.warcraft.monolith.app.command.service.DefaultCommandCommandService;
import gg.warcraft.monolith.app.command.service.DefaultCommandQueryService;
import gg.warcraft.monolith.app.command.service.DefaultCommandRepository;
import gg.warcraft.monolith.app.config.service.DefaultConfigurationQueryService;
import gg.warcraft.monolith.app.config.service.DefaultConfigurationRepository;
import gg.warcraft.monolith.app.config.service.GitHubConfigurationCommandService;
import gg.warcraft.monolith.app.config.service.LocalConfigurationCommandService;
import gg.warcraft.monolith.app.core.GuavaEventService;
import gg.warcraft.monolith.app.effect.vectors.CircleVectors;
import gg.warcraft.monolith.app.effect.vectors.DomeVectors;
import gg.warcraft.monolith.app.effect.vectors.LineVectors;
import gg.warcraft.monolith.app.effect.vectors.OriginVector;
import gg.warcraft.monolith.app.effect.vectors.PointVector;
import gg.warcraft.monolith.app.effect.vectors.RingVectors;
import gg.warcraft.monolith.app.effect.vectors.SphereVectors;
import gg.warcraft.monolith.app.entity.attribute.service.DefaultAttributeCommandService;
import gg.warcraft.monolith.app.entity.attribute.service.DefaultAttributeQueryService;
import gg.warcraft.monolith.app.entity.attribute.service.DefaultAttributeRepository;
import gg.warcraft.monolith.app.entity.status.service.DefaultStatusCommandService;
import gg.warcraft.monolith.app.entity.status.service.DefaultStatusQueryService;
import gg.warcraft.monolith.app.entity.status.service.DefaultStatusRepository;
import gg.warcraft.monolith.app.item.SimpleItemBuilder;
import gg.warcraft.monolith.app.item.SimpleItemReader;
import gg.warcraft.monolith.app.persistence.JacksonJsonMapper;
import gg.warcraft.monolith.app.persistence.JacksonYamlMapper;
import gg.warcraft.monolith.app.persistence.JedisPersistenceService;
import gg.warcraft.monolith.app.util.DefaultMathUtils;
import gg.warcraft.monolith.app.util.DefaultStringUtils;
import gg.warcraft.monolith.app.util.DefaultTimeUtils;
import gg.warcraft.monolith.app.world.service.DefaultWorldQueryService;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class AbstractMonolithModule extends MonolithModule {
    private static String persistenceService;
    private static String redisHost;
    private static int redisPort;
    private static String configurationService;
    private static String gitHubAccount;
    private static String gitHubRepository;

    public static void setPersistenceService(String persistenceService) {
        AbstractMonolithModule.persistenceService = persistenceService;
    }

    public static void setRedisHost(String redisHost) {
        AbstractMonolithModule.redisHost = redisHost;
    }

    public static void setRedisPort(int redisPort) {
        AbstractMonolithModule.redisPort = redisPort;
    }

    public static void setConfigurationService(String configurationService) {
        AbstractMonolithModule.configurationService = configurationService;
    }

    public static void setGitHubAccount(String gitHubAccount) {
        AbstractMonolithModule.gitHubAccount = gitHubAccount;
    }

    public static void setGitHubRepository(String gitHubRepository) {
        AbstractMonolithModule.gitHubRepository = gitHubRepository;
    }

    @Override
    protected void configure() {
        configureCommand();
        configureConfiguration();
        configureCore();
        configureEffect();
        configureEntity();
        configureItem();
        configurePersistence();
        configureUtil();
        configureWorld();
    }

    private void configureCommand() {
        bind(CommandCommandService.class).to(DefaultCommandCommandService.class);
        bind(CommandQueryService.class).to(DefaultCommandQueryService.class);
        bind(CommandRepository.class).to(DefaultCommandRepository.class);

        bind(CommandSender.class).annotatedWith(Console.class).to(ConsoleCommandSender.class);
    }

    private void configureConfiguration() {
        switch (configurationService) {
            case "LOCAL":
                bind(ConfigurationCommandService.class).to(LocalConfigurationCommandService.class);
                bind(ConfigurationQueryService.class).to(DefaultConfigurationQueryService.class);
                bind(ConfigurationRepository.class).to(DefaultConfigurationRepository.class);
                break;
            case "GITHUB":
                bind(String.class).annotatedWith(Names.named("GitHubAccount")).toInstance(gitHubAccount);
                bind(String.class).annotatedWith(Names.named("GitHubRepository")).toInstance(gitHubRepository);

                bind(ConfigurationCommandService.class).to(GitHubConfigurationCommandService.class);
                bind(ConfigurationQueryService.class).to(DefaultConfigurationQueryService.class);
                bind(ConfigurationRepository.class).to(DefaultConfigurationRepository.class);
            default:
                throw new IllegalArgumentException("Illegal configurationService in Monolith configuration: " + configurationService);
        }
    }

    private void configureCore() {
        bind(EventService.class).to(GuavaEventService.class).in(Singleton.class);
    }

    private void configureEffect() {
        install(new FactoryModuleBuilder()
                .implement(EffectVectors.class, Names.named("circle"), CircleVectors.class)
                .implement(EffectVectors.class, Names.named("dome"), DomeVectors.class)
                .implement(EffectVectors.class, Names.named("line"), LineVectors.class)
                .implement(EffectVectors.class, Names.named("origin"), OriginVector.class)
                .implement(EffectVectors.class, Names.named("point"), PointVector.class)
                .implement(EffectVectors.class, Names.named("ring"), RingVectors.class)
                .implement(EffectVectors.class, Names.named("sphere"), SphereVectors.class)
                .build(EffectVectorsFactory.class));
    }

    private void configureEntity() {
        bind(AttributeCommandService.class).to(DefaultAttributeCommandService.class);
        bind(AttributeQueryService.class).to(DefaultAttributeQueryService.class);
        bind(AttributeRepository.class).to(DefaultAttributeRepository.class);

        bind(StatusCommandService.class).to(DefaultStatusCommandService.class);
        bind(StatusQueryService.class).to(DefaultStatusQueryService.class);
        bind(StatusRepository.class).to(DefaultStatusRepository.class);
    }

    private void configureItem() {
        install(new FactoryModuleBuilder()
                .implement(ItemBuilder.class, SimpleItemBuilder.class)
                .build(ItemBuilderFactory.class));
        install(new FactoryModuleBuilder()
                .implement(ItemReader.class, SimpleItemReader.class)
                .build(ItemReaderFactory.class));
    }

    private void configurePersistence() {
        bind(JsonMapper.class).to(JacksonJsonMapper.class);
        bind(YamlMapper.class).to(JacksonYamlMapper.class);

        switch (persistenceService) {
            case "REDIS":
                JedisPoolConfig jedisConfiguration = new JedisPoolConfig();
                jedisConfiguration.setBlockWhenExhausted(false);
                jedisConfiguration.setMaxTotal(8);
                JedisPool jedisPool = new JedisPool(jedisConfiguration, redisHost, redisPort, 10);
                bind(JedisPool.class).toInstance(jedisPool);

                bind(PersistenceService.class).to(JedisPersistenceService.class);
            default:
                throw new IllegalArgumentException("Illegal persistenceService in Monolith configuration: " + persistenceService);
        }
    }

    private void configureUtil() {
        bind(MathUtils.class).to(DefaultMathUtils.class);
        bind(StringUtils.class).to(DefaultStringUtils.class);
        bind(TimeUtils.class).to(DefaultTimeUtils.class);
    }

    private void configureWorld() {
        bind(WorldQueryService.class).to(DefaultWorldQueryService.class);
    }
}
