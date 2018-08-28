package gg.warcraft.monolith.spigot.entity.player;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import gg.warcraft.monolith.api.entity.EntityType;
import gg.warcraft.monolith.api.entity.player.PlayerServerData;
import gg.warcraft.monolith.api.item.Item;
import gg.warcraft.monolith.spigot.entity.SpigotEntityData;
import gg.warcraft.monolith.spigot.entity.SpigotEntityTypeMapper;
import gg.warcraft.monolith.spigot.item.SpigotItemMapper;
import gg.warcraft.monolith.spigot.world.location.SpigotLocationMapper;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SpigotPlayerData extends SpigotEntityData implements PlayerServerData {
    private final SpigotItemMapper itemMapper;
    private final Player player;

    @Inject
    public SpigotPlayerData(SpigotEntityTypeMapper entityTypeMapper, SpigotLocationMapper locationMapper,
                            SpigotItemMapper itemMapper, @Assisted Player player) {
        super(entityTypeMapper, locationMapper, itemMapper, player);
        this.itemMapper = itemMapper;
        this.player = player;
    }

    @Override
    public EntityType getType() {
        return EntityType.PLAYER;
    }

    @Override
    public List<Item> getInventory() {
        ItemStack[] items = player.getInventory().getContents();
        return Arrays.stream(items)
                .map(itemMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isSneaking() {
        return player.isSneaking();
    }
}
