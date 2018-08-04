package gg.warcraft.monolith.spigot.entity;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import gg.warcraft.monolith.api.entity.EntityServerData;
import gg.warcraft.monolith.api.entity.EntityType;
import gg.warcraft.monolith.api.entity.Equipment;
import gg.warcraft.monolith.api.item.Item;
import gg.warcraft.monolith.api.world.OrientedLocation;
import gg.warcraft.monolith.app.entity.SimpleEquipment;
import gg.warcraft.monolith.spigot.item.SpigotItemMapper;
import gg.warcraft.monolith.spigot.world.SpigotLocationMapper;
import net.minecraft.server.v1_12_R1.AxisAlignedBB;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftLivingEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.Vector;
import org.joml.AABBf;
import org.joml.Vector3f;

import java.util.UUID;

public class SpigotEntityData implements EntityServerData {
    private final SpigotEntityTypeMapper entityTypeMapper;
    private final SpigotLocationMapper locationMapper;
    private final SpigotItemMapper itemMapper;
    private final LivingEntity entity;

    @Inject
    public SpigotEntityData(SpigotEntityTypeMapper entityTypeMapper, SpigotLocationMapper locationMapper,
                            SpigotItemMapper itemMapper, @Assisted LivingEntity entity) {
        this.entityTypeMapper = entityTypeMapper;
        this.locationMapper = locationMapper;
        this.itemMapper = itemMapper;
        this.entity = entity;
    }

    @Override
    public UUID getEntityId() {
        return entity.getUniqueId();
    }

    @Override
    public EntityType getType() {
        return entityTypeMapper.map(entity.getType());
    }

    @Override
    public String getName() {
        return entity.getName();
    }

    @Override
    public OrientedLocation getLocation() {
        return locationMapper.map(entity);
    }

    @Override
    public OrientedLocation getEyeLocation() {
        return locationMapper.mapEye(entity);
    }

    @Override
    public Vector3f getVelocity() {
        Vector velocity = entity.getVelocity();
        return new Vector3f((float) velocity.getX(), (float) velocity.getY(), (float) velocity.getZ());
    }

    @Override
    public float getHealth() {
        return (float) entity.getHealth();
    }

    @Override
    public Equipment getEquipment() {
        Item helmet = itemMapper.map(entity.getEquipment().getHelmet());
        Item chest = itemMapper.map(entity.getEquipment().getChestplate());
        Item legs = itemMapper.map(entity.getEquipment().getLeggings());
        Item feet = itemMapper.map(entity.getEquipment().getBoots());
        Item mainHand = itemMapper.map(entity.getEquipment().getItemInMainHand());
        Item offHand = itemMapper.map(entity.getEquipment().getItemInOffHand());
        return new SimpleEquipment(helmet, chest, legs, feet, mainHand, offHand);
    }

    @Override
    public AABBf getBoundingBox() {
        AxisAlignedBB boundingBox = ((CraftLivingEntity) entity).getHandle().getBoundingBox();
        return new AABBf((float) boundingBox.a, (float) boundingBox.b, (float) boundingBox.c,
                (float) boundingBox.d, (float) boundingBox.e, (float) boundingBox.f);
    }

    @Override
    public boolean hasPermission(String permission) {
        return entity.hasPermission(permission);
    }
}
