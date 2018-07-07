package gg.warcraft.monolith.app.entity;

import gg.warcraft.monolith.api.entity.Entity;
import gg.warcraft.monolith.api.entity.EntityData;
import gg.warcraft.monolith.api.entity.EntityServerData;
import gg.warcraft.monolith.api.entity.EntityType;
import gg.warcraft.monolith.api.entity.Team;
import gg.warcraft.monolith.api.entity.attribute.Attributes;
import gg.warcraft.monolith.api.entity.status.Status;
import gg.warcraft.monolith.api.util.Lazy;
import gg.warcraft.monolith.api.world.OrientedLocation;
import org.joml.Vector3f;

import java.util.UUID;
import java.util.function.Supplier;

public class LazyEntity implements Entity {
    private final Lazy<? extends EntityData> data;
    private final Lazy<EntityServerData> serverData;
    private final Lazy<Attributes> attributes;
    private final Lazy<Status> status;

    public LazyEntity(Supplier<? extends EntityData> dataSupplier, Supplier<EntityServerData> serverDataSupplier,
                      Supplier<Attributes> attributesSupplier, Supplier<Status> statusSupplier) {
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
    public boolean hasPermission(String permission) {
        return serverData.get().hasPermission(permission);
    }
}
