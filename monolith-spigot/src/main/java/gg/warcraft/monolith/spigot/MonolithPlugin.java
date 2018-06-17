package gg.warcraft.monolith.spigot;

import com.google.inject.Guice;
import com.google.inject.Injector;
import gg.warcraft.monolith.api.Monolith;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

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
            System.out.println("If you have configured Monolith make sure to set firstTimeSetup to false.");
            getServer().shutdown();
        }

        MonolithConfiguration configuration = null;

        boolean maintenance = config.getBoolean("maintenance");
        if (maintenance) {
            // TODO setup maintenance login and session checker
        }

        String configurationService = getConfig().getString("configurationService");
        String persistenceService = getConfig().getString("persistenceService");

        String overworldName = getConfig().getString("worldName");
        String theNetherName = getConfig().getString("theNetherName");
        String theEndName = getConfig().getString("theEndName");

        Injector injector = Guice.createInjector(new SpigotMonolithModule(overworldName));

        // initialize injector for consumers
        new Monolith(injector);


    }
}
