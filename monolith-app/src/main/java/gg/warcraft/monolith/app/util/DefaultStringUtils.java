package gg.warcraft.monolith.app.util;

import gg.warcraft.monolith.api.util.StringUtils;

import java.util.regex.Pattern;

public class DefaultStringUtils implements StringUtils {
    private static final Pattern chatCodePattern = Pattern.compile("§.");

    public boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) >= 0;
    }

    public String removeChatCodes(String string) {
        return chatCodePattern.matcher(string).replaceAll("");
    }
}
