package gg.warcraft.monolith.api.item;

import gg.warcraft.monolith.api.entity.attribute.Attribute;

public interface ItemReader {

    String getType();

    int getAttribute(Attribute attribute);
}
