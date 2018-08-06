package gg.warcraft.monolith.app.util;

import gg.warcraft.monolith.api.util.Duration;
import gg.warcraft.monolith.api.util.TimeUtils;

public class DefaultTimeUtils implements TimeUtils {
    private final Duration immediately;
    private final Duration oneMilli;
    private final Duration oneTick;
    private final Duration oneSecond;

    public DefaultTimeUtils() {
        this.immediately = createDurationInTicks(0);
        this.oneMilli = createDurationInMillis(1);
        this.oneTick = createDurationInTicks(1);
        this.oneSecond = createDurationInSeconds(1);
    }

    @Override
    public String getTimeElapsedSince(long unixTimestamp) {
        long age = System.currentTimeMillis() - unixTimestamp;
        if (age < MILLIS_PER_MINUTE) {
            return "less than a minute";
        } else if (age < MILLIS_PER_HOUR) {
            long count = age / MILLIS_PER_MINUTE;
            return count + (count != 1 ? " minutes" : " minute");
        } else if (age < MILLIS_PER_DAY) {
            long count = age / MILLIS_PER_HOUR;
            return count + (count != 1 ? " hours" : " hour");
        } else {
            long count = age / MILLIS_PER_DAY;
            return count + (count != 1 ? " days" : " day");
        }
    }

    @Override
    public Duration createDurationInMillis(int millis) {
        return new SimpleDuration(Duration.Type.MILLIS, millis);
    }

    @Override
    public Duration createDurationInTicks(int ticks) {
        return new SimpleDuration(Duration.Type.TICKS, ticks);
    }

    @Override
    public Duration createDurationInSeconds(int seconds) {
        return new SimpleDuration(Duration.Type.SECONDS, seconds);
    }

    @Override
    public Duration immediately() {
        return immediately;
    }

    @Override
    public Duration oneMilli() {
        return oneMilli;
    }

    @Override
    public Duration oneTick() {
        return oneTick;
    }

    @Override
    public Duration oneSecond() {
        return oneSecond;
    }
}
