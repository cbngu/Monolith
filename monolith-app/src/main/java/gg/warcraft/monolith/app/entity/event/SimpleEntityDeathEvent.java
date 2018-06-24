package gg.warcraft.monolith.app.entity.event;

import gg.warcraft.monolith.api.entity.event.EntityDeathEvent;
import gg.warcraft.monolith.api.item.ItemType;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SimpleEntityDeathEvent extends AbstractEntityEvent implements EntityDeathEvent {
    private final List<ItemType> drops;

    public SimpleEntityDeathEvent(UUID entityId, List<ItemType> drops) {
        super(entityId);
        this.drops = drops;
    }

    @Override
    public List<ItemType> getDrops() {
        return new ArrayList<>(drops);
    }

    @Override
    public void setDrops(List<ItemType> drops) {
        this.drops.clear();
        this.drops.addAll(drops);
    }
}
