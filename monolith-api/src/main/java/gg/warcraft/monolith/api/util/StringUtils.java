package gg.warcraft.monolith.api.util;

/**
 * This utility is injectable.
 * <p>
 * StringUtils provides utility methods for string operations.
 */
public interface StringUtils {

    /**
     * Returns whether or not the char is a vowel.
     *
     * @return True if the char is a vowel, false otherwise.
     */
    boolean isVowel(char c);
}
