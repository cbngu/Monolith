package gg.warcraft.monolith.api.util;

/**
 * ColorCode serves as an abstraction layer between Monolith plugin code and the eventual server implementation the
 * plugin is run on. Apart from the fact that it offers a null object it is identical to Spigot's {@code ChatColor}.
 */
public enum ColorCode {
    BLACK("§0"),
    DARK_BLUE("§1"),
    DARK_GREEN("§2"),
    DARK_AQUA("§3"),
    DARK_RED("§4"),
    DARK_PURPLE("§5"),
    GOLD("§6"),
    GRAY("§7"),
    DARK_GRAY("§8"),
    BLUE("§9"),
    GREEN("§a"),
    AQUA("§b"),
    RED("§c"),
    LIGHT_PURPLE("§d"),
    YELLOW("§e"),
    WHITE("§f"),
    NULL("");

    private final String code;

    ColorCode(String code) {
        this.code = code;
    }

    /**
     * @return The string representation of this color code as accepted by Minecraft. Never null, but can be empty.
     */
    @Override
    public String toString() {
        return code;
    }
}
