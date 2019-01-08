package gg.warcraft.monolith.spigot.entity;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import gg.warcraft.monolith.api.entity.EntityServerData;
import gg.warcraft.monolith.api.entity.EntityType;
import gg.warcraft.monolith.api.entity.Equipment;
import gg.warcraft.monolith.api.item.Item;
import gg.warcraft.monolith.api.world.location.OrientedLocation;
import gg.warcraft.monolith.app.entity.SimpleEquipment;
import gg.warcraft.monolith.spigot.item.SpigotItemMapper;
import gg.warcraft.monolith.spigot.world.location.SpigotLocationMapper;
import net.minecraft.server.v1_12_R1.AxisAlignedBB;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftLivingEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.Vector;
import org.joml.AABBf;
import org.joml.Vector3f;

import java.util.UUID;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

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
        UUID entityId = entity.getUniqueId();
        return checkNotNull(entityId);
    }

    @Override
    public EntityType getType() {
        EntityType type = entityTypeMapper.map(entity.getType());
        return checkNotNull(type);
    }

    @Override
    public String getName() {
        String name = entity.getName();
        checkState(name != null);
        checkState(!name.isEmpty());
        return name;
    }

    @Override
    public OrientedLocation getLocation() {
        OrientedLocation location = locationMapper.map(entity);
        return checkNotNull(location);
    }

    @Override
    public OrientedLocation getEyeLocation() {
        OrientedLocation eyeLocation = locationMapper.mapEye(entity);
        return checkNotNull(eyeLocation);
    }

    @Override
    public Vector3f getVelocity() {
        Vector velocity = entity.getVelocity();
        checkState(velocity != null);
        return new Vector3f(
                (float) velocity.getX(),
                (float) velocity.getY(),
                (float) velocity.getZ());
    }

    @Override
    public float getHealth() {
        return (float) entity.getHealth();
    }

    @Override
    public Equipment getEquipment() {
        // TODO how do we want to check this state, is null legal?

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
