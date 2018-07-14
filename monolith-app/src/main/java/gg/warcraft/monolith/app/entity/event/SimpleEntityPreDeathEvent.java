package gg.warcraft.monolith.app.entity.event;

import gg.warcraft.monolith.api.entity.event.EntityPreDeathEvent;
import gg.warcraft.monolith.api.item.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SimpleEntityPreDeathEvent extends SimpleEntityPreEvent implements EntityPreDeathEvent {
    private List<Item> drops;

    public SimpleEntityPreDeathEvent(UUID entityId, boolean cancelled) {
        super(entityId, cancelled);
    }

    @Override
    public List<Item> getDrops() {
        return new ArrayList<>(drops);
    }

    @Override
    public void setDrops(List<Item> drops) {
        this.drops = new ArrayList<>(drops);
    }
}
