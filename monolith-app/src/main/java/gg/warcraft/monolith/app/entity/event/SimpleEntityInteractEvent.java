package gg.warcraft.monolith.app.entity.event;

import gg.warcraft.monolith.api.entity.event.EntityInteractEvent;
import gg.warcraft.monolith.api.item.Item;
import gg.warcraft.monolith.api.world.Location;

import java.util.UUID;

public class SimpleEntityInteractEvent extends SimpleEntityEvent implements EntityInteractEvent {
    private final UUID playerId;
    private final Item itemInClickHand;
    private final Location interactLocation;

    public SimpleEntityInteractEvent(UUID entityId, UUID playerId, Item itemInClickHand, Location interactLocation) {
        super(entityId);
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
