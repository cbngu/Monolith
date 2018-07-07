package gg.warcraft.monolith.spigot.item;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.item.Item;
import gg.warcraft.monolith.spigot.world.MaterialData;
import org.bukkit.inventory.ItemStack;

public class SpigotItemMapper {
    private final SpigotItemTypeMapper itemTypeMapper;

    @Inject
    public SpigotItemMapper(SpigotItemTypeMapper itemTypeMapper) {
        this.itemTypeMapper = itemTypeMapper;
    }

    public ItemStack map(Item item) {
        MaterialData materialData = itemTypeMapper.map(item.getType());
        return new ItemStack(materialData.getMaterial(), item.getStackSize(), (short) item.getDamage(),
                materialData.getData());
    }
}
