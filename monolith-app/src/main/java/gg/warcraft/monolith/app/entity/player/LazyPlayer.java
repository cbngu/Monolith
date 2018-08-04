package gg.warcraft.monolith.app.entity.player;

import gg.warcraft.monolith.api.entity.attribute.Attributes;
import gg.warcraft.monolith.api.entity.player.Player;
import gg.warcraft.monolith.api.entity.player.PlayerProfile;
import gg.warcraft.monolith.api.entity.player.PlayerServerData;
import gg.warcraft.monolith.api.entity.status.Status;
import gg.warcraft.monolith.api.item.Item;
import gg.warcraft.monolith.api.util.Lazy;
import gg.warcraft.monolith.app.entity.LazyEntity;

import java.util.List;
import java.util.function.Supplier;

public class LazyPlayer extends LazyEntity implements Player {
    private final Lazy<PlayerProfile> profile;
    private final Lazy<PlayerServerData> serverData;

    public LazyPlayer(Supplier<PlayerProfile> profileSupplier, Supplier<PlayerServerData> serverDataSupplier,
                      Supplier<Attributes> attributesSupplier, Supplier<Status> statusSupplier) {
        super(profileSupplier, serverDataSupplier, attributesSupplier, statusSupplier);
        this.profile = new Lazy<>(profileSupplier);
        this.serverData = new Lazy<>(serverDataSupplier);
    }

    @Override
    public long getTimeConnected() {
        return profile.get().getTimeConnected();
    }

    @Override
    public long getTimeFirstConnected() {
        return profile.get().getTimeFirstConnected();
    }

    @Override
    public long getTimeLastSeen() {
        return profile.get().getTimeLastSeen();
    }

    @Override
    public long getTimePlayed() {
        return profile.get().getTimePlayed();
    }

    @Override
    public int getCurrency(String currency) {
        return profile.get().getCurrencies().getOrDefault(currency, 0);
    }

    @Override
    public int getLifetimeCurrency(String currency) {
        return profile.get().getLifetimeCurrencies().getOrDefault(currency, 0);
    }

    @Override
    public List<Item> getInventory() {
        return serverData.get().getInventory();
    }

    @Override
    public boolean isSneaking() {
        return serverData.get().isSneaking();
    }
}
