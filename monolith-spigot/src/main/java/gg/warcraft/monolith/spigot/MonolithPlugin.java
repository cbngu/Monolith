package gg.warcraft.monolith.spigot;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import gg.warcraft.monolith.api.Monolith;
import gg.warcraft.monolith.api.core.EventService;
import gg.warcraft.monolith.app.command.ConsoleCommandSender;
import gg.warcraft.monolith.app.command.PlayerCommandSender;
import gg.warcraft.monolith.app.command.event.SimpleCommandExecutedEvent;
import gg.warcraft.monolith.app.command.handler.CommandExecutedHandler;
import gg.warcraft.monolith.spigot.event.SpigotEntityEventMapper;
import gg.warcraft.monolith.spigot.event.SpigotPlayerEventMapper;
import gg.warcraft.monolith.spigot.event.SpigotWorldEventMapper;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MonolithPlugin extends JavaPlugin {
    private Injector injector;
    private EventService eventService;

    void initializeInjector() {
        List<AbstractModule> monolithModules = Monolith.getModules();
        List<String> monolithModuleNames = monolithModules.stream()
                .map(module -> module.getClass().getSimpleName())
                .collect(Collectors.toList());
        getLogger().info("Found " + monolithModules.size() + " Monolith modules: " + monolithModuleNames);
        Injector injector = Guice.createInjector(monolithModules);
        new Monolith(injector);
    }

    void initializeMonolithEventHandlers() {
        CommandExecutedHandler commandExecutedHandler = injector.getInstance(CommandExecutedHandler.class);
        eventService.subscribe(commandExecutedHandler);
    }

    void initializeSpigotEventMappers() {
        SpigotEntityEventMapper entityEventMapper = injector.getInstance(SpigotEntityEventMapper.class);
        getServer().getPluginManager().registerEvents(entityEventMapper, this);

        SpigotPlayerEventMapper playerEventMapper = injector.getInstance(SpigotPlayerEventMapper.class);
        getServer().getPluginManager().registerEvents(playerEventMapper, this);

        SpigotWorldEventMapper worldEventMapper = injector.getInstance(SpigotWorldEventMapper.class);
        getServer().getPluginManager().registerEvents(worldEventMapper, this);
    }

    @Override
    public void onLoad() {
        saveDefaultConfig();
    }

    @Override
    public void onEnable() {
        FileConfiguration localConfig = getConfig();

        boolean isFirstTimeSetup = localConfig.getBoolean("firstTimeSetup");
        if (isFirstTimeSetup) {
            getLogger().severe("Monolith has not been configured yet, shutting down server.");
            getLogger().severe("If you have finished configuration make sure to set firstTimeSetup to false.");
            getServer().shutdown();
        }

        boolean maintenance = localConfig.getBoolean("maintenance");
        if (maintenance) {
            // TODO setup maintenance login and session checker
        }

        String configurationService = localConfig.getString("configurationService");
        String gitHubAccount = localConfig.getString("gitHubAccount");
        String gitHubRepository = localConfig.getString("gitHubRepository");

        String persistenceService = localConfig.getString("persistenceService");
        String redisHost = localConfig.getString("redisHost");
        int redisPort = localConfig.getInt("redisPort");

        String entityService = localConfig.getString("entityService");

        String overworldName = localConfig.getString("worldName");
        String theNetherName = localConfig.getString("theNetherName");
        String theEndName = localConfig.getString("theEndName");

        AbstractModule spigotMonolithModule = new SpigotMonolithModule(
                configurationService, gitHubAccount, gitHubRepository,
                persistenceService, redisHost, redisPort,
                entityService, this,
                overworldName, theNetherName, theEndName);
        Monolith.registerModule(spigotMonolithModule);

        initializeInjector();
        injector = Monolith.getInstance().getInjector();
        eventService = injector.getInstance(EventService.class);

        initializeMonolithEventHandlers();
        initializeSpigotEventMappers();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        eventService.publish(new SimpleCommandExecutedEvent(
                (sender instanceof Player)
                        ? new PlayerCommandSender(sender.getName(), ((Player) sender).getUniqueId())
                        : new ConsoleCommandSender(),
                command.getName(),
                label,
                Arrays.asList(args)));
        return true;
    }
}
