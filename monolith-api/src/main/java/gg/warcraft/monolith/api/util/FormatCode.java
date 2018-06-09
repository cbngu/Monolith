package gg.warcraft.monolith.api.util;

/**
 * FormatCode serves as an abstraction layer between Monolith plugin code and the eventual server implementation the
 * plugin is run on. Apart from the fact that it offers a null object it is identical to Spigot's {@code ChatColor}.
 */
public enum FormatCode {
    OBFUSCATED("§k"),
    BOLD("§l"),
    STRIKETHROUGH("§m"),
    UNDERLINE("§n"),
    ITALIC("§o"),
    RESET("§r"),
    NULL("");

    private final String code;

    FormatCode(String code) {
        this.code = code;
    }

    /**
     * @return The string representation of this formatting code as accepted by Minecraft. Never null, but can be empty.
     */
    @Override
    public String toString() {
        return code;
    }
}
