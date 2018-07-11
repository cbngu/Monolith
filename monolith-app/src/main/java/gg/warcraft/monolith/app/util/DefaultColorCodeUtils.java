package gg.warcraft.monolith.app.util;

import gg.warcraft.monolith.api.util.ColorCodeUtils;

public class DefaultColorCodeUtils implements ColorCodeUtils {
    private static final String COLOR_CODE_REGEX = "§[0-9a-f]";

    @Override
    public String stripColorCodes(String string) {
        return string.replaceAll(COLOR_CODE_REGEX, "");
    }
}
