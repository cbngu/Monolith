package gg.warcraft.monolith.app.entity.player;

import gg.warcraft.monolith.api.entity.EntityServerData;
import gg.warcraft.monolith.api.entity.attribute.Attributes;
import gg.warcraft.monolith.api.entity.player.Player;
import gg.warcraft.monolith.api.entity.player.PlayerData;
import gg.warcraft.monolith.api.entity.status.Status;
import gg.warcraft.monolith.api.util.Lazy;
import gg.warcraft.monolith.app.entity.LazyEntity;

import java.util.function.Supplier;

public class LazyPlayer extends LazyEntity implements Player {
    private final Lazy<PlayerData> data;

    public LazyPlayer(Supplier<PlayerData> dataSupplier, Supplier<EntityServerData> serverDataSupplier,
                      Supplier<Attributes> attributesSupplier, Supplier<Status> statusSupplier) {
        super(dataSupplier, serverDataSupplier, attributesSupplier, statusSupplier);
        this.data = new Lazy<>(dataSupplier);
    }

    @Override
    public String getMinecraftName() {
        return data.get().getMinecraftName();
    }

    @Override
    public String getDisplayName() {
        return data.get().getDisplayName();
    }

    @Override
    public long getTimeOfConnect() {
        return data.get().getTimeOfConnect();
    }

    @Override
    public long getTimeOfFirstConnect() {
        return data.get().getTimeOfFirstConnect();
    }

    @Override
    public long getTimePlayed() {
        return data.get().getTimePlayed();
    }
}
