package gg.warcraft.monolith.spigot;

import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.google.inject.name.Names;
import gg.warcraft.monolith.api.command.service.CommandServerAdapter;
import gg.warcraft.monolith.api.core.AuthorizationService;
import gg.warcraft.monolith.api.core.TaskService;
import gg.warcraft.monolith.api.effect.Particle;
import gg.warcraft.monolith.api.effect.ParticleFactory;
import gg.warcraft.monolith.api.entity.player.service.PlayerServerAdapter;
import gg.warcraft.monolith.api.entity.service.EntityServerAdapter;
import gg.warcraft.monolith.api.world.service.WorldServerAdapter;
import gg.warcraft.monolith.app.AbstractMonolithModule;
import gg.warcraft.monolith.app.effect.particle.MultiParticle;
import gg.warcraft.monolith.app.effect.particle.QueuedParticle;
import gg.warcraft.monolith.spigot.command.SpigotCommandAdapter;
import gg.warcraft.monolith.spigot.core.SpigotAuthorizationService;
import gg.warcraft.monolith.spigot.core.SpigotTaskService;
import gg.warcraft.monolith.spigot.entity.adapter.SpigotEntityAdapter;
import gg.warcraft.monolith.spigot.entity.player.adapter.SpigotPlayerAdapter;
import gg.warcraft.monolith.spigot.particle.ColorParticle;
import gg.warcraft.monolith.spigot.particle.SpeedParticle;
import gg.warcraft.monolith.spigot.world.Overworld;
import gg.warcraft.monolith.spigot.world.TheEnd;
import gg.warcraft.monolith.spigot.world.TheNether;
import gg.warcraft.monolith.spigot.world.service.SpigotWorldAdapter;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.plugin.Plugin;

public class SpigotMonolithModule extends AbstractMonolithModule {
    private static Plugin plugin;
    private static String overworldName;
    private static String theNetherName;
    private static String theEndName;

    public static void setPlugin(Plugin plugin) {
        SpigotMonolithModule.plugin = plugin;
    }

    public static void setOverworldName(String overworldName) {
        SpigotMonolithModule.overworldName = overworldName;
    }

    public static void setTheNetherName(String theNetherName) {
        SpigotMonolithModule.theNetherName = theNetherName;
    }

    public static void setTheEndName(String theEndName) {
        SpigotMonolithModule.theEndName = theEndName;
    }

    protected void configure() {
        super.configure();
        configureBukkit();
        configureCommand();
        configureCore();
        configureEffect();
        configureEntity();
        configureWorld();
    }

    private void configureBukkit() {
        bind(Plugin.class).toInstance(plugin);
        bind(Server.class).toProvider(plugin::getServer);
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
                .implement(Particle.class, Names.named("color"), ColorParticle.class)
                .implement(Particle.class, Names.named("speed"), SpeedParticle.class)
                .implement(Particle.class, Names.named("multi"), MultiParticle.class)
                .implement(Particle.class, Names.named("queued"), QueuedParticle.class)
                .build(ParticleFactory.class));
    }

    private void configureEntity() {
        bind(EntityServerAdapter.class).to(SpigotEntityAdapter.class);
        bind(PlayerServerAdapter.class).to(SpigotPlayerAdapter.class);
    }

    private void configureWorld() {
        bind(WorldServerAdapter.class).to(SpigotWorldAdapter.class);
    }
}
