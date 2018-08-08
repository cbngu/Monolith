package gg.warcraft.monolith.spigot;

import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.google.inject.name.Names;
import gg.warcraft.monolith.api.command.service.CommandServerAdapter;
import gg.warcraft.monolith.api.core.AuthorizationService;
import gg.warcraft.monolith.api.core.PluginLogger;
import gg.warcraft.monolith.api.core.TaskService;
import gg.warcraft.monolith.api.effect.Particle;
import gg.warcraft.monolith.api.effect.ParticleFactory;
import gg.warcraft.monolith.api.entity.EntityServerData;
import gg.warcraft.monolith.api.entity.player.PlayerServerData;
import gg.warcraft.monolith.api.entity.player.hiding.PlayerHidingServerAdapter;
import gg.warcraft.monolith.api.entity.player.service.PlayerServerAdapter;
import gg.warcraft.monolith.api.entity.service.EntityServerAdapter;
import gg.warcraft.monolith.api.menu.service.MenuServerAdapter;
import gg.warcraft.monolith.api.world.WorldType;
import gg.warcraft.monolith.api.world.service.WorldServerAdapter;
import gg.warcraft.monolith.app.AbstractMonolithModule;
import gg.warcraft.monolith.app.effect.particle.MultiParticle;
import gg.warcraft.monolith.app.effect.particle.QueuedParticle;
import gg.warcraft.monolith.spigot.command.SpigotCommandAdapter;
import gg.warcraft.monolith.spigot.core.SpigotAuthorizationService;
import gg.warcraft.monolith.spigot.core.SpigotTaskService;
import gg.warcraft.monolith.spigot.entity.SpigotEntityData;
import gg.warcraft.monolith.spigot.entity.SpigotEntityDataFactory;
import gg.warcraft.monolith.spigot.entity.player.SpigotPlayerData;
import gg.warcraft.monolith.spigot.entity.player.SpigotPlayerDataFactory;
import gg.warcraft.monolith.spigot.entity.player.hiding.SpigotPlayerHidingAdapter;
import gg.warcraft.monolith.spigot.entity.player.service.SpigotPlayerAdapter;
import gg.warcraft.monolith.spigot.entity.service.SpigotEntityAdapter;
import gg.warcraft.monolith.spigot.menu.service.SpigotMenuAdapter;
import gg.warcraft.monolith.spigot.particle.ColorParticle;
import gg.warcraft.monolith.spigot.particle.SimpleParticle;
import gg.warcraft.monolith.spigot.particle.SpeedParticle;
import gg.warcraft.monolith.spigot.world.Overworld;
import gg.warcraft.monolith.spigot.world.TheEnd;
import gg.warcraft.monolith.spigot.world.TheNether;
import gg.warcraft.monolith.spigot.world.service.SpigotWorldAdapter;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.plugin.Plugin;
import org.joml.Vector3ic;

import java.util.logging.Logger;

public class SpigotMonolithModule extends AbstractMonolithModule {
    private final Plugin plugin;
    private final String overworldName;
    private final String theNetherName;
    private final String theEndName;

    public SpigotMonolithModule(String configurationService, String gitHubAccount, String gitHubRepository,
                                String persistenceService, String redisHost, int redisPort,
                                String entityService, String playerService, WorldType buildRepositoryWorld,
                                Vector3ic buildRepositoryMinimumCorner, Vector3ic buildRepositoryMaximumCorner,
                                Plugin plugin, String overworldName, String theNetherName, String theEndName) {
        super(configurationService, gitHubAccount, gitHubRepository, persistenceService, redisHost, redisPort,
                entityService, playerService, buildRepositoryWorld, buildRepositoryMinimumCorner,
                buildRepositoryMaximumCorner);
        this.plugin = plugin;
        this.overworldName = overworldName;
        this.theNetherName = theNetherName;
        this.theEndName = theEndName;
    }

    protected void configure() {
        super.configure();
        configureBukkit();
        configureCommand();
        configureCore();
        configureEffect();
        configureEntity();
        configureMenu();
        configureWorld();
    }

    private void configureBukkit() {
        bind(Plugin.class).toInstance(plugin);
        bind(Server.class).toProvider(plugin::getServer);
        bind(Logger.class).annotatedWith(PluginLogger.class).toProvider(plugin::getLogger);
        bind(World.class).annotatedWith(Overworld.class).toProvider(() -> plugin.getServer().getWorld(overworldName));
        bind(World.class).annotatedWith(TheNether.class).toProvider(() -> plugin.getServer().getWorld(theNetherName));
        bind(World.class).annotatedWith(TheEnd.class).toProvider(() -> plugin.getServer().getWorld(theEndName));
    }

    private void configureCommand() {
        bind(CommandServerAdapter.class).to(SpigotCommandAdapter.class);
    }

    private void configureCore() {
        bind(AuthorizationService.class).to(SpigotAuthorizationService.class);
        bind(TaskService.class).to(SpigotTaskService.class);
    }

    private void configureEffect() {
        install(new FactoryModuleBuilder()
                .implement(Particle.class, Names.named("simple"), SimpleParticle.class)
                .implement(Particle.class, Names.named("color"), ColorParticle.class)
                .implement(Particle.class, Names.named("speed"), SpeedParticle.class)
                .implement(Particle.class, Names.named("multi"), MultiParticle.class)
                .implement(Particle.class, Names.named("queued"), QueuedParticle.class)
                .build(ParticleFactory.class));
    }

    private void configureEntity() {
        bind(EntityServerAdapter.class).to(SpigotEntityAdapter.class);
        bind(PlayerServerAdapter.class).to(SpigotPlayerAdapter.class);
        bind(PlayerHidingServerAdapter.class).to(SpigotPlayerHidingAdapter.class);

        install(new FactoryModuleBuilder()
                .implement(EntityServerData.class, SpigotEntityData.class)
                .build(SpigotEntityDataFactory.class));
        install(new FactoryModuleBuilder()
                .implement(PlayerServerData.class, SpigotPlayerData.class)
                .build(SpigotPlayerDataFactory.class));
    }

    private void configureMenu() {
        bind(MenuServerAdapter.class).to(SpigotMenuAdapter.class);
    }

    private void configureWorld() {
        bind(WorldServerAdapter.class).to(SpigotWorldAdapter.class);
    }
}
