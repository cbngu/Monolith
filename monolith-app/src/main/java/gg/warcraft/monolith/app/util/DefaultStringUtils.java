package gg.warcraft.monolith.app.util;

import gg.warcraft.monolith.api.util.StringUtils;

public class DefaultStringUtils implements StringUtils {

    public boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) >= 0;
    }
}
