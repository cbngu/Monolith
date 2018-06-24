package gg.warcraft.monolith.spigot.world.service;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.item.ItemType;
import gg.warcraft.monolith.api.world.Location;
import gg.warcraft.monolith.api.world.WorldType;
import gg.warcraft.monolith.api.world.block.Block;
import gg.warcraft.monolith.api.world.block.BlockType;
import gg.warcraft.monolith.api.world.service.WorldServerAdapter;
import gg.warcraft.monolith.spigot.world.MaterialData;
import gg.warcraft.monolith.spigot.world.SpigotBlockMapper;
import gg.warcraft.monolith.spigot.world.SpigotItemTypeMapper;
import gg.warcraft.monolith.spigot.world.SpigotLocationMapper;
import gg.warcraft.monolith.spigot.world.SpigotWorldMapper;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class SpigotWorldAdapter implements WorldServerAdapter {
    private final SpigotWorldMapper worldMapper;
    private final SpigotBlockMapper blockMapper;
    private final SpigotLocationMapper locationMapper;
    private final SpigotItemTypeMapper itemTypeMapper;

    @Inject
    public SpigotWorldAdapter(SpigotWorldMapper worldMapper, SpigotBlockMapper blockMapper,
                              SpigotLocationMapper locationMapper, SpigotItemTypeMapper itemTypeMapper) {
        this.worldMapper = worldMapper;
        this.blockMapper = blockMapper;
        this.locationMapper = locationMapper;
        this.itemTypeMapper = itemTypeMapper;
    }

    @Override
    public Block getBlockAt(WorldType world, int x, int y, int z) {
        World spigotWorld = worldMapper.map(world);
        org.bukkit.block.Block spigotBlock = spigotWorld.getBlockAt(x, y, z);
        return blockMapper.map(spigotBlock);
    }

    @Override
    public void setBlockType(Block block, BlockType type) {
        org.bukkit.block.Block spigotBlock = blockMapper.map(block);
        spigotBlock.setTypeIdAndData(type.getId(), (byte) type.getData(), false);
    }

    @Override
    public void dropItemsAt(List<ItemType> items, Location location) {
        org.bukkit.Location spigotLocation = locationMapper.map(location);
        World world = spigotLocation.getWorld();
        items.forEach(item -> {
            MaterialData materialData = itemTypeMapper.map(item);
            ItemStack itemStack = new ItemStack(materialData.getMaterial(), 1, (short) 0, materialData.getData());
            world.dropItem(spigotLocation, itemStack);
        });
    }
}
