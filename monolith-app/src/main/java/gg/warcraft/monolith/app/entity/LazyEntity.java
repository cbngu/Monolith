package gg.warcraft.monolith.app.entity;

import gg.warcraft.monolith.api.entity.Entity;
import gg.warcraft.monolith.api.entity.EntityProfile;
import gg.warcraft.monolith.api.entity.EntityServerData;
import gg.warcraft.monolith.api.entity.EntityType;
import gg.warcraft.monolith.api.entity.Equipment;
import gg.warcraft.monolith.api.entity.Team;
import gg.warcraft.monolith.api.entity.attribute.Attributes;
import gg.warcraft.monolith.api.entity.status.Status;
import gg.warcraft.monolith.api.util.Lazy;
import gg.warcraft.monolith.api.world.OrientedLocation;
import org.joml.AABBf;
import org.joml.Vector3f;

import java.util.UUID;
import java.util.function.Supplier;

public class LazyEntity implements Entity {
    private final Lazy<? extends EntityProfile> data;
    private final Lazy<? extends EntityServerData> serverData;
    private final Lazy<Attributes> attributes;
    private final Lazy<Status> status;

    public LazyEntity(Supplier<? extends EntityProfile> dataSupplier,
                      Supplier<? extends EntityServerData> serverDataSupplier,
                      Supplier<Attributes> attributesSupplier,
                      Supplier<Status> statusSupplier) {
        this.data = new Lazy<>(dataSupplier);
        this.serverData = new Lazy<>(serverDataSupplier);
        this.attributes = new Lazy<>(attributesSupplier);
        this.status = new Lazy<>(statusSupplier);
    }

    @Override
    public UUID getId() {
        return serverData.get().getEntityId();
    }

    @Override
    public EntityType getType() {
        return serverData.get().getType();
    }

    @Override
    public String getName() {
        return serverData.get().getName();
    }

    @Override
    public OrientedLocation getLocation() {
        return serverData.get().getLocation();
    }

    @Override
    public OrientedLocation getEyeLocation() {
        return serverData.get().getEyeLocation();
    }

    @Override
    public Vector3f getVelocity() {
        return serverData.get().getVelocity();
    }

    @Override
    public float getHealth() {
        return serverData.get().getHealth();
    }

    @Override
    public Team getTeam() {
        return data.get().getTeam();
    }

    @Override
    public Attributes getAttributes() {
        return attributes.get();
    }

    @Override
    public Status getStatus() {
        return status.get();
    }

    @Override
    public Equipment getEquipment() {
        return serverData.get().getEquipment();
    }

    @Override
    public AABBf getBoundingBox() {
        return serverData.get().getBoundingBox();
    }

    @Override
    public boolean hasPermission(String permission) {
        return serverData.get().hasPermission(permission);
    }
}
