package gg.warcraft.monolith.app.item;

import gg.warcraft.monolith.api.entity.attribute.Attribute;
import gg.warcraft.monolith.api.item.Item;
import gg.warcraft.monolith.api.item.ItemReader;

import java.util.List;

public class SimpleItemReader implements ItemReader {
    private static final int PLUS_INDEX = 0;

    private final Item item;

    public SimpleItemReader(Item item) {
        this.item = item;
    }

    @Override
    public int getAttribute(Attribute attribute) {
        List<String> lore = item.getLore();
        for (String line : lore) {
            if (line.contains(attribute.getName())) {
                int spaceIndex = line.indexOf(" ");
                String attributeValueSubString = line.substring(PLUS_INDEX + 1, spaceIndex);
                return Integer.parseInt(attributeValueSubString);
            }
        }
        return 0;
    }
}
