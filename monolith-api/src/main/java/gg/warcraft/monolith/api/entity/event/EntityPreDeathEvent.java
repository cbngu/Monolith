package gg.warcraft.monolith.api.entity.event;

import gg.warcraft.monolith.api.item.Item;

import java.util.List;

public interface EntityPreDeathEvent extends EntityPreEvent {

    List<Item> getDrops();

    void setDrops(List<Item> drops);
}
