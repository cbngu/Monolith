package gg.warcraft.monolith.spigot.world;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.world.World;
import gg.warcraft.monolith.api.world.WorldType;
import gg.warcraft.monolith.app.world.SimpleWorld;

import javax.annotation.Nullable;

public class SpigotWorldMapper {
    private final org.bukkit.World overworld;
    private final org.bukkit.World nether;
    private final org.bukkit.World end;

    @Inject
    public SpigotWorldMapper(@Overworld org.bukkit.World overworld,
                             @Nullable @TheNether org.bukkit.World nether,
                             @Nullable @TheEnd org.bukkit.World end) {
        this.overworld = overworld;
        this.nether = nether;
        this.end = end;
    }

    public org.bukkit.World map(World world) {
        return map(world.getType());
    }

    public org.bukkit.World map(WorldType type) {
        switch (type) {
            case THE_NETHER:
                return nether;
            case THE_END:
                return end;
            case OVERWORLD:
            default:
                return overworld;
        }
    }

    public World map(org.bukkit.World world) {
        switch (world.getEnvironment()) {
            case NETHER:
                return new SimpleWorld(WorldType.THE_NETHER);
            case THE_END:
                return new SimpleWorld(WorldType.THE_END);
            case NORMAL:
            default:
                return new SimpleWorld(WorldType.OVERWORLD);
        }
    }
}
