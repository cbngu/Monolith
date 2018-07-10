package gg.warcraft.monolith.app.entity.player;

import gg.warcraft.monolith.api.entity.attribute.Attributes;
import gg.warcraft.monolith.api.entity.player.Player;
import gg.warcraft.monolith.api.entity.player.PlayerData;
import gg.warcraft.monolith.api.entity.player.PlayerServerData;
import gg.warcraft.monolith.api.entity.status.Status;
import gg.warcraft.monolith.api.item.Item;
import gg.warcraft.monolith.api.util.Lazy;
import gg.warcraft.monolith.app.entity.LazyEntity;

import java.util.List;
import java.util.function.Supplier;

public class LazyPlayer extends LazyEntity implements Player {
    private final Lazy<PlayerData> data;
    private final Lazy<PlayerServerData> serverData;

    public LazyPlayer(Supplier<PlayerData> dataSupplier, Supplier<PlayerServerData> serverDataSupplier,
                      Supplier<Attributes> attributesSupplier, Supplier<Status> statusSupplier) {
        super(dataSupplier, serverDataSupplier, attributesSupplier, statusSupplier);
        this.data = new Lazy<>(dataSupplier);
        this.serverData = new Lazy<>(serverDataSupplier);
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

    @Override
    public List<Item> getInventory() {
        return serverData.get().getInventory();
    }
}
