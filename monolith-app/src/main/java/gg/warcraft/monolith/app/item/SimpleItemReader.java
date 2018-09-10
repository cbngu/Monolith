package gg.warcraft.monolith.app.item;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import gg.warcraft.monolith.api.entity.attribute.Attribute;
import gg.warcraft.monolith.api.item.Item;
import gg.warcraft.monolith.api.item.ItemReader;

import java.util.List;

public class SimpleItemReader implements ItemReader {
    private final Item item;

    @Inject
    public SimpleItemReader(@Assisted Item item) {
        this.item = item;
    }

    @Override
    public int getAttribute(Attribute attribute) {
        List<String> lore = item.getLore();
        for (String line : lore) {
            if (line.contains(attribute.getName())) {
                String cleanedLine = line.replaceAll("[\\D]", "");
                try {
                    return Integer.parseInt(cleanedLine);
                } catch (NumberFormatException ex) {
                    return 0;
                }
            }
        }
        return 0;
    }
}
