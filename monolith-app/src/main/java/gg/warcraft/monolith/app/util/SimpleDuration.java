package gg.warcraft.monolith.app.util;

import gg.warcraft.monolith.api.util.Duration;
import gg.warcraft.monolith.api.util.TimeUtils;

public class SimpleDuration implements Duration {
    private static final float MILLIS_PER_TICK_RECIPROCAL = (1f / TimeUtils.MILLIS_PER_TICK);
    private static final float MILLIS_PER_SECOND_RECIPROCAL = (1f / TimeUtils.MILLIS_PER_SECOND);
    private static final float TICKS_PER_SECOND_RECIPROCAL = (1f / TimeUtils.TICKS_PER_SECOND);

    private final int millis;
    private final int ticks;
    private final int seconds;

    public SimpleDuration(Duration.Type type, int duration) {
        switch (type) {
            case MILLIS:
                this.millis = duration;
                this.ticks = (int) (duration * MILLIS_PER_TICK_RECIPROCAL);
                this.seconds = (int) (duration * MILLIS_PER_SECOND_RECIPROCAL);
                break;
            case TICKS:
                this.millis = duration * TimeUtils.MILLIS_PER_TICK;
                this.ticks = duration;
                this.seconds = (int) (duration * TICKS_PER_SECOND_RECIPROCAL);
                break;
            case SECONDS:
                this.millis = duration * TimeUtils.MILLIS_PER_SECOND;
                this.ticks = duration * TimeUtils.TICKS_PER_SECOND;
                this.seconds = duration;
                break;
            default:
                throw new IllegalArgumentException("Failed to instantiate Duration with unsupported type: " + type);
        }
    }

    @Override
    public int inMillis() {
        return millis;
    }

    @Override
    public int inTicks() {
        return ticks;
    }

    @Override
    public int inSeconds() {
        return seconds;
    }
}
