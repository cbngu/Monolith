package gg.warcraft.monolith.app.entity.event;

import gg.warcraft.monolith.api.entity.event.EntityPreInteractEvent;
import gg.warcraft.monolith.api.item.Item;
import gg.warcraft.monolith.api.world.Location;

import java.util.UUID;

public class SimpleEntityPreInteractEvent extends SimpleEntityPreEvent implements EntityPreInteractEvent {
    private final UUID playerId;
    private final Item itemInClickHand;
    private final Location interactLocation;

    public SimpleEntityPreInteractEvent(UUID entityId, UUID playerId, Item itemInClickHand, Location interactLocation,
                                        boolean cancelled) {
        super(entityId, cancelled);
        this.playerId = playerId;
        this.itemInClickHand = itemInClickHand;
        this.interactLocation = interactLocation;
    }

    @Override
    public UUID getPlayerId() {
        return playerId;
    }

    @Override
    public Item getItemInClickHand() {
        return itemInClickHand;
    }

    @Override
    public Location getInteractLocation() {
        return interactLocation;
    }
}
