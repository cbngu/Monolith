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
import gg.warcraft.monolith.api.item.ItemBuilder;
import gg.warcraft.monolith.api.item.ItemBuilderFactory;
import gg.warcraft.monolith.api.item.ItemReader;
import gg.warcraft.monolith.api.item.ItemReaderFactory;
import gg.warcraft.monolith.api.world.service.WorldServerAdapter;
import gg.warcraft.monolith.app.AbstractMonolithModule;
import gg.warcraft.monolith.app.effect.particle.MultiParticle;
import gg.warcraft.monolith.app.effect.particle.QueuedParticle;
import gg.warcraft.monolith.app.item.SimpleItemBuilder;
import gg.warcraft.monolith.app.item.SimpleItemReader;
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
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.plugin.Plugin;

public class SpigotMonolithModule extends AbstractMonolithModule {
    private final static String PLUGIN_NAME = "WarCraft: Monolith";

    private final String worldName;

    public SpigotMonolithModule(String worldName) {
        this.worldName = worldName;
    }

    protected void configure() {
        super.configure();
        configureBukkit();
        configureCommand();
        configureCore();
        configureEffect();
        configureEntity();
        configureItem();
        configureWorld();
    }

    private void configureBukkit() {
        bind(Server.class).toProvider(Bukkit::getServer);
        bind(Plugin.class).toProvider(() -> Bukkit.getPluginManager().getPlugin(PLUGIN_NAME));
        bind(World.class).annotatedWith(Overworld.class).toProvider(() -> Bukkit.getWorld(worldName));
        bind(World.class).annotatedWith(TheNether.class).toProvider(() -> Bukkit.getWorld(worldName + "_nether"));
        bind(World.class).annotatedWith(TheEnd.class).toProvider(() -> Bukkit.getWorld(worldName + "_the_end"));
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

    private void configureItem() {
        install(new FactoryModuleBuilder()
                .implement(ItemBuilder.class, SimpleItemBuilder.class)
                .build(ItemBuilderFactory.class));
        install(new FactoryModuleBuilder()
                .implement(ItemReader.class, SimpleItemReader.class)
                .build(ItemReaderFactory.class));
    }

    private void configureWorld() {
        bind(WorldServerAdapter.class).to(SpigotWorldAdapter.class);
    }
}
