package gg.warcraft.monolith.api.entity;

import com.google.inject.assistedinject.Assisted;
import com.google.inject.name.Named;
import gg.warcraft.monolith.api.entity.attribute.Attributes;
import gg.warcraft.monolith.api.entity.player.Player;
import gg.warcraft.monolith.api.entity.player.PlayerProfile;
import gg.warcraft.monolith.api.entity.player.PlayerServerData;
import gg.warcraft.monolith.api.entity.status.Status;

import java.util.function.Supplier;

public interface EntityFactory {

    @Named("entity")
    Entity createEntity(@Assisted("profile") Supplier<EntityProfile> profileSupplier,
                        @Assisted("data") Supplier<EntityServerData> serverDataSupplier,
                        @Assisted("attributes") Supplier<Attributes> attributesSupplier,
                        @Assisted("status") Supplier<Status> statusSupplier);

    @Named("player")
    Player createPlayer(@Assisted("profile") Supplier<PlayerProfile> profileSupplier,
                        @Assisted("data") Supplier<PlayerServerData> serverDataSupplier,
                        @Assisted("attributes") Supplier<Attributes> attributesSupplier,
                        @Assisted("status") Supplier<Status> statusSupplier);
}
