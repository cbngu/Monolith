package gg.warcraft.monolith.api.util;

/**
 * This utility is injectable.
 * <p>
 * StringUtils provides utility methods for string operations.
 */
public interface StringUtils {

    /**
     * @return True if the character is a vowel, false otherwise.
     */
    boolean isVowel(char c);

    /**
     * @param string The original string. Can not be null, but can be empty.
     * @return A new string from the original string with all {@code ColorCode} and {@code FormatCode} removed.
     * Never null, but can be empty.
     */
    String removeChatCodes(String string);
}
