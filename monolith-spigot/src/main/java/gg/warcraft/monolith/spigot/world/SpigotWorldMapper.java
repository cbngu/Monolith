package gg.warcraft.monolith.spigot.world;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.world.WorldType;
import gg.warcraft.monolith.app.world.SimpleWorld;
import org.bukkit.World;

public class SpigotWorldMapper {
    private final World overworld;
    private final World nether;
    private final World end;

    @Inject
    public SpigotWorldMapper(@Overworld World overworld, @TheNether World nether, @TheEnd World end) {
        this.overworld = overworld;
        this.nether = nether;
        this.end = end;
    }

    public World map(gg.warcraft.monolith.api.world.World world) {
        return map(world.getType());
    }

    public World map(WorldType type) {
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

    public gg.warcraft.monolith.api.world.World map(World world) {
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
