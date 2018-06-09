package gg.warcraft.monolith.api.util;

/**
 * ColorHue serves as an abstraction layer between Monolith plugin code and the eventual server implementation the
 * plugin is run on. It is identical to Spigot's {@code Color} and the server adapter will substitute its values with
 * the correct implementation during runtime.
 */
public enum ColorHue {
    WHITE(16777215),
    SILVER(12632256),
    GRAY(8421504),
    BLACK(0),
    RED(16711680),
    MAROON(8388608),
    YELLOW(16776960),
    OLIVE(8421376),
    LIME(65280),
    GREEN(32768),
    AQUA(65535),
    TEAL(32896),
    BLUE(255),
    NAVY(128),
    FUCHSIA(16711935),
    PURPLE(8388736),
    ORANGE(16753920);

    private final int rgb;

    ColorHue(int rgb) {
        this.rgb = rgb;
    }

    /**
     * @return The RGB value as integer of this color.
     */
    public int getRgb() {
        return rgb;
    }
}
