package gg.warcraft.monolith.api.util;

/**
 * Duration is a utility class that allows consumers to simply ask for a duration without imposing a specific time unit
 * on the caller.
 */
public interface Duration {
    enum Type {
        MILLIS,
        TICKS,
        SECONDS
    }

    /**
     * Returns the value of this duration in milliseconds.
     *
     * @return The value of this duration in milliseconds.
     */
    int inMillis();

    /**
     * Returns the value of this duration in ticks.
     * <p>
     * The internal conversion from millis to ticks is done using integer division and care should be taken that
     * accuracy will be lost when reading a duration originally created using millis as ticks.
     *
     * @return The value of this duration in ticks.
     */
    int inTicks();

    /**
     * Returns the value of this duration in seconds.
     * <p>
     * The internal conversion from millis or ticks to seconds is done using integer division and care should be taken
     * that accuracy will be lost when reading a duration originally created using millis or ticks as seconds.
     *
     * @return The value of this duration in seconds.
     */
    int inSeconds();
}
