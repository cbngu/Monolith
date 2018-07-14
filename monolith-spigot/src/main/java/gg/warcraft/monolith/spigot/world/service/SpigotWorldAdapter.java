package gg.warcraft.monolith.spigot.world.service;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.item.Item;
import gg.warcraft.monolith.api.world.Location;
import gg.warcraft.monolith.api.world.WorldType;
import gg.warcraft.monolith.api.world.block.Block;
import gg.warcraft.monolith.api.world.block.BlockType;
import gg.warcraft.monolith.api.world.block.Sign;
import gg.warcraft.monolith.api.world.service.WorldServerAdapter;
import gg.warcraft.monolith.spigot.item.SpigotItemMapper;
import gg.warcraft.monolith.spigot.world.SpigotBlockMapper;
import gg.warcraft.monolith.spigot.world.SpigotLocationMapper;
import gg.warcraft.monolith.spigot.world.SpigotWorldMapper;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.UUID;

public class SpigotWorldAdapter implements WorldServerAdapter {
    private final Server server;
    private final SpigotWorldMapper worldMapper;
    private final SpigotBlockMapper blockMapper;
    private final SpigotLocationMapper locationMapper;
    private final SpigotItemMapper itemMapper;

    @Inject
    public SpigotWorldAdapter(Server server, SpigotWorldMapper worldMapper, SpigotBlockMapper blockMapper,
                              SpigotLocationMapper locationMapper, SpigotItemMapper itemMapper) {
        this.server = server;
        this.worldMapper = worldMapper;
        this.blockMapper = blockMapper;
        this.locationMapper = locationMapper;
        this.itemMapper = itemMapper;
    }

    @Override
    public gg.warcraft.monolith.api.world.World getWorld(WorldType type) {
        return worldMapper.map(worldMapper.map(type));
    }

    @Override
    public Block getBlockAt(WorldType world, int x, int y, int z) {
        World spigotWorld = worldMapper.map(world);
        org.bukkit.block.Block spigotBlock = spigotWorld.getBlockAt(x, y, z);
        return blockMapper.map(spigotBlock);
    }

    @Override
    public Block getHighestBlockAt(WorldType world, int x, int z) {
        World spigotWorld = worldMapper.map(world);
        org.bukkit.block.Block spigotBlock = spigotWorld.getHighestBlockAt(x, z);
        return blockMapper.map(spigotBlock);
    }

    @Override
    public void setBlockType(Block block, BlockType type) {
        org.bukkit.block.Block spigotBlock = blockMapper.map(block);
        spigotBlock.setTypeIdAndData(type.getId(), (byte) type.getData(), false);
    }

    @Override
    public void setSignLines(Sign sign, String[] lines) {
        org.bukkit.block.Block spigotBlock = blockMapper.map(sign);
        org.bukkit.block.Sign spigotSign = (org.bukkit.block.Sign) spigotBlock.getState();
        spigotSign.setLine(0, lines[0]);
        spigotSign.setLine(1, lines[1]);
        spigotSign.setLine(2, lines[2]);
        spigotSign.setLine(3, lines[3]);
        spigotSign.update(true, false);
    }

    @Override
    public void dropItemsAt(List<Item> items, Location location) {
        org.bukkit.Location spigotLocation = locationMapper.map(location);
        World world = spigotLocation.getWorld();
        items.forEach(item -> {
            ItemStack itemStack = itemMapper.map(item);
            world.dropItem(spigotLocation, itemStack);
        });
    }

    @Override
    public void spoofBlock(Block fakeBlock, UUID playerId) {
        Player player = server.getPlayer(playerId);
        if (player != null) {
            org.bukkit.block.Block spigotBlock = blockMapper.map(fakeBlock);
            player.sendBlockChange(spigotBlock.getLocation(), spigotBlock.getType(), spigotBlock.getData());
        }
    }
}
