package gg.warcraft.monolith.app.item;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import gg.warcraft.monolith.api.entity.attribute.Attribute;
import gg.warcraft.monolith.api.item.Item;
import gg.warcraft.monolith.api.item.ItemReader;

import javax.annotation.Nullable;
import java.util.List;
import java.util.regex.Pattern;

public class SimpleItemReader implements ItemReader {
    private static final Pattern chatCodePattern = Pattern.compile("§.");

    private final Item item;

    @Inject
    public SimpleItemReader(@Assisted @Nullable Item item) {
        this.item = item;
    }

    private String removeChatCodes(String string) {
        return chatCodePattern.matcher(string).replaceAll("");
    }

    @Override
    public String getType() {
        if (item == null) {
            return null;
        }

        List<String> lore = item.getLore();
        if (lore.size() == 1 || removeChatCodes(lore.get(1)).isEmpty()) {
            return removeChatCodes(lore.get(0));
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
                String rawLine = removeChatCodes(line);
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
