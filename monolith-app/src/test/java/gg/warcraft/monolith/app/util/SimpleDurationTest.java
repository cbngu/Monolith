package gg.warcraft.monolith.app.util;

import gg.warcraft.monolith.api.util.Duration;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimpleDurationTest {

    @Test
    public void inMillis_shouldCorrectlyConvert() {
        var three = 3;

        var threeMillis = new SimpleDuration(Duration.Type.MILLIS, three);
        assertEquals(3, threeMillis.inMillis());

        var threeTicks = new SimpleDuration(Duration.Type.TICKS, three);
        assertEquals(150, threeTicks.inMillis());

        var threeSeconds = new SimpleDuration(Duration.Type.SECONDS, three);
        assertEquals(3000, threeSeconds.inMillis());
    }

    @Test
    public void inTicks_shouldCorrectlyConvert() {
        var sixty = 60;

        var sixtyMillis = new SimpleDuration(Duration.Type.MILLIS, sixty);
        assertEquals(1, sixtyMillis.inTicks());

        var sixtyTicks = new SimpleDuration(Duration.Type.TICKS, sixty);
        assertEquals(60, sixtyTicks.inTicks());

        var sixtySeconds = new SimpleDuration(Duration.Type.SECONDS, sixty);
        assertEquals(1200, sixtySeconds.inTicks());
    }

    @Test
    public void inSeconds_shouldCorrectlyConvert() {
        var twoThousand = 2000;

        var twoThousandMillis = new SimpleDuration(Duration.Type.MILLIS, twoThousand);
        assertEquals(2, twoThousandMillis.inSeconds());

        var twoThousandTicks = new SimpleDuration(Duration.Type.TICKS, twoThousand);
        assertEquals(100, twoThousandTicks.inSeconds());

        var twoThousandSeconds = new SimpleDuration(Duration.Type.SECONDS, twoThousand);
        assertEquals(2000, twoThousandSeconds.inSeconds());
    }
}
