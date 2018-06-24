package gg.warcraft.monolith.spigot;

import com.google.common.collect.Lists;
import com.google.inject.Guice;
import com.google.inject.Injector;
import gg.warcraft.monolith.api.Monolith;
import gg.warcraft.monolith.api.MonolithModule;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.ServiceLoader;

public class MonolithPlugin extends JavaPlugin {

    @Override
    public void onLoad() {

    }

    @Override
    public void onEnable() {
        FileConfiguration config = getConfig();

        boolean isFirstTimeSetup = config.getBoolean("firstTimeSetup");
        if (isFirstTimeSetup) {
            System.out.println("Monolith has not been configured yet, shutting down server.");
            System.out.println("If you have configured it make sure to set firstTimeSetup in the config to false.");
            getServer().shutdown();
        }

        boolean maintenance = config.getBoolean("maintenance");
        if (maintenance) {
            // TODO setup maintenance login and session checker
        }

        String configurationService = getConfig().getString("configurationService");
        String persistenceService = getConfig().getString("persistenceService");

        String overworldName = getConfig().getString("worldName");
        String theNetherName = getConfig().getString("theNetherName");
        String theEndName = getConfig().getString("theEndName");

        ServiceLoader<MonolithModule> monolithModuleLoader = ServiceLoader.load(MonolithModule.class);
        List<MonolithModule> monolithModules = Lists.newArrayList(monolithModuleLoader.iterator());
        monolithModules.add(new SpigotMonolithModule(overworldName));
        Injector injector = Guice.createInjector(monolithModules);

        // initialize injector for consumers
        new Monolith(injector);


    }
}
