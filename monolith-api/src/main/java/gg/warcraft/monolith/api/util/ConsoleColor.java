package gg.warcraft.monolith.api.util;

/**
 * ConsoleColor is a utility enumeration allowing for easy coloring of console output. Make sure you end the colored log
 * statements with {@code ConsoleColor.RESET} or else the console will keep printing in the last used color (not all
 * colors are supported by all consoles).
 */
public enum ConsoleColor {
    BLACK("\u001B[30m"),
    BLUE("\u001B[34m"),
    CYAN("\u001B[36m"),
    GREEN("\u001B[32m"),
    PURPLE("\u001B[35m"),
    RED("\u001B[31m"),
    WHITE("\u001B[37m"),
    YELLOW("\u001B[33m"),
    RESET("\u001B[0m"),
    NULL("");

    private final String value;

    ConsoleColor(String value) {
        this.value = value;
    }

    /**
     * Returns the string representation of this color code as accepted by most consoles.
     *
     * @return The string representation of this color code as accepted by most consoles. Never null, but can be empty.
     */
    @Override
    public String toString() {
        return value;
    }
}
