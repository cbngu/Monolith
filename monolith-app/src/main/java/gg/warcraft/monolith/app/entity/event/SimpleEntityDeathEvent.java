package gg.warcraft.monolith.app.entity.event;

import gg.warcraft.monolith.api.entity.event.EntityDeathEvent;
import gg.warcraft.monolith.api.item.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SimpleEntityDeathEvent extends SimpleEntityEvent implements EntityDeathEvent {
    private final List<Item> drops;

    public SimpleEntityDeathEvent(UUID entityId, List<Item> drops) {
        super(entityId);
        this.drops = drops;
    }

    @Override
    public List<Item> getDrops() {
        return new ArrayList<>(drops);
    }

    @Override
    public void setDrops(List<Item> drops) {
        throw new IllegalStateException("Not implemented");
        // TODO do we want this?
    }
}
