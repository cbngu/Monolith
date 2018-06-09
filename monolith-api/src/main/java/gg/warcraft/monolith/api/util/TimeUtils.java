package gg.warcraft.monolith.api.util;

/**
 * This utility is injectable.
 * <p>
 * TimeUtils provides utility methods and exposes constants for time based operations. It also serves as a factory for
 * {@code Duration} objects.
 */
public interface TimeUtils {
    int SECONDS_PER_MINUTE = 60;
    int SECONDS_PER_HOUR = 60 * SECONDS_PER_MINUTE;
    int SECONDS_PER_DAY = 24 * SECONDS_PER_HOUR;

    int TICKS_PER_SECOND = 20;
    int TICKS_PER_MINUTE = 60 * TICKS_PER_SECOND;
    int TICKS_PER_HOUR = 60 * TICKS_PER_MINUTE;
    int TICKS_PER_DAY = 24 * TICKS_PER_HOUR;

    int MILLIS_PER_TICK = 50;
    int MILLIS_PER_SECOND = 1000;
    int MILLIS_PER_MINUTE = 60 * MILLIS_PER_SECOND;
    int MILLIS_PER_HOUR = 60 * MILLIS_PER_MINUTE;
    int MILLIS_PER_DAY = 24 * MILLIS_PER_HOUR;

    /**
     * @param unixTimestamp The unix timestamp in milliseconds.
     * @return The time elapsed since the unix timestamp in a human readable format. Never null, but can be empty.
     */
    String getTimeElapsedSince(long unixTimestamp);

    /**
     * @param millis The duration in milliseconds.
     * @return A new {@code Duration} for the specified milliseconds. Never null.
     */
    Duration createDurationInMillis(int millis);

    /**
     * @param millis The duration in ticks.
     * @return A new {@code Duration} for the specified ticks. Never null.
     */
    Duration createDurationInTicks(int ticks);

    /**
     * @param millis The duration in seconds.
     * @return A new {@code Duration} for the specified seconds. Never null.
     */
    Duration createDurationInSeconds(int seconds);

    /**
     * @return A {@code Duration} for one millisecond. Never null.
     */
    Duration oneMilli();

    /**
     * @return A {@code Duration} for one tick. Never null.
     */
    Duration oneTick();

    /**
     * @return A {@code Duration} for one second. Never null.
     */
    Duration oneSecond();
}
