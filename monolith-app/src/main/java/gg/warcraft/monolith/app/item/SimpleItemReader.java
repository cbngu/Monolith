package gg.warcraft.monolith.app.item;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import gg.warcraft.monolith.api.entity.attribute.Attribute;
import gg.warcraft.monolith.api.item.Item;
import gg.warcraft.monolith.api.item.ItemReader;
import gg.warcraft.monolith.api.util.StringUtils;

import javax.annotation.Nullable;
import java.util.List;

public class SimpleItemReader implements ItemReader {
    private final StringUtils stringUtils;
    private final Item item;

    @Inject
    public SimpleItemReader(StringUtils stringUtils,
                            @Assisted @Nullable Item item) {
        this.stringUtils = stringUtils;
        this.item = item;
    }

    @Override
    public String getType() {
        if (item == null) {
            return null;
        }

        List<String> lore = item.getLore();
        String itemTypeSeparator = stringUtils.removeChatCodes(lore.get(1));
        if (lore.size() == 1 || itemTypeSeparator.isEmpty()) {
            return stringUtils.removeChatCodes(lore.get(0));
        }
        return null;
    }

    @Override
    public int getAttribute(Attribute attribute) {
        if (item == null) {
            return 0;
        }

        List<String> lore = item.getLore();
        for (String line : lore) {
            if (line.contains(attribute.getName())) {
                String rawLine = stringUtils.removeChatCodes(line);
                String onlyNumbers = rawLine.replaceAll("[\\D]", "");
                try {
                    return Integer.parseInt(onlyNumbers);
                } catch (NumberFormatException ex) {
                    return 0;
                }
            }
        }
        return 0;
    }
}
